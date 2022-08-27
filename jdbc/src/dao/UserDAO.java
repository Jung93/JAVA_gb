package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import vo.UserVO;

public class UserDAO {
	//암호화를 위한 상수 KEY
	private final int KEY = 3;
	
	public Connection connection; //연결 객체
	public PreparedStatement preparedStatement; //쿼리(SQL문) 객체
	//쿼리문이 SELECT인 경우 결과 테이블이 존재하기 때문에
	//ResultSet 타입의 객체를 선언해서 받아준다.
	public ResultSet resultSet; //결과 테이블 객체
	
//	아이디 중복검사
	//실패 혹은 성공 둘 중 하나
	public boolean checkId(String id) {
//		USER_ID 컬럼에서 사용자가 입력한 id 검사
//		SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_ID = ?
//		USER_ID는 UK라 반복이 없음. 따라서 USER_ID와 입력한 id가 같은 값만 불러와서 집계함수인
//		COUNT(USER_ID)를 사용하면 1이 나옴.
//		1이 나온다는 것은 입력한 아이디가 USER 테이블에 이미 존재하는 것.
//		0이 나온다는 것은 존재하지 않는 것.
//		쿼리문에서 ? 자리에는 입력한 값이 들어감
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER WHERE USER_ID = ?";
//		boolean 타입을 리턴하는 메소드에서 리턴값을 저장할 check를 미리 선언. 초기값은 false 넣어줌
		boolean check = false;
		
		try {
//			연결 객체 가져오기
//			DBConnecter에 선언한 getConnection을 이용해서 연동
			connection = DBConnecter.getConnection();
//			작성한 쿼리문을 preparedStatement에 전달
			preparedStatement = connection.prepareStatement(query);
//			? 채우기(좌에서 우로 1부터 1씩 증가)
//			set 뒤에는 컬럼의 타입에 따라 달라짐. 
//			USER_ID 컬럼이 VARCHAR2 타입이라 자바에서는 String
//			SQL에서 인덱스는 무조건 1부터 시작. 자바와는 다름
//			인덱스 뒤에는 ? 에 전달할 값
			preparedStatement.setString(1, id);
//			쿼리 실행
//			쿼리문의 시작이 SELECT 인 경우 executeQuery()
//			쿼리문의 시작이 SELECT가 아닌 경우 executeUpdate()
//			resultSet에는 executeQuery()의 실행 결과(테이블)가 담긴다. 
			resultSet = preparedStatement.executeQuery();
			
//			결과 행 1개 가져오기
//			next()의 리턴타입 boolean. 가져올 값이 있다면 true, 값이 없다면 false
//			이 메소드에서 next()는 0, 1 둘 중 하나이기때문에 항상 true이다.
//			따라서 if문으로 감쌀 필요가 없다.
			if(resultSet.next()) {
				
//			결과 첫번째 열 1개 가져오기
//			결과가 1이라면 사용자가 입력한 아이디가 1개 조회된 것이기 때문에 중복된 아이디이다.
//			중복되면 check가 true 바뀜, 중복이 없다면 false
				check = resultSet.getInt(1) == 1;
			}
		} catch (SQLException e) {//쿼리 실행 오류가 발생하면 잡는 catch
			System.out.println("checkId()에서 쿼리문 오류");
		} finally {//close는 모두 finally 안에서!
			try {
//				연결 객체 모두 닫기
//				연결 객체 닫는 순서는 여는 순서와 반대로
//				열기 : A B C
//				닫기 : C B A
//				null이 아니라는 것은 쿼리가 정상 작동했다는 것이므로 close()한다
//				세 개의 조건을 확인해야 하므로 if문을 3개 사용
				if(resultSet != null) {
					resultSet.close();
				}
				
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
//				제대로 닫히지 않을 경우 프로세스를 강제 종료
//				throws는 예외를 실행 주체에게 넘기는 것
//				throw는 일부러 예외를 발생시키는 것
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return check;
	}
	
//	회원가입
//		회원의 모든 정보를 전달받아서 DB랑 연동해야 하기 때무에
//		모델 객체를 매개변수로 받는다
	public void insert(UserVO userVO) {
//		쿼리 시작이 INSERT
		String query = "INSERT INTO TBL_USER "
//				넘길 컬럼과 ?의 수를 맞춰주자
				+ "(USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB)"
				+ "VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			//나중에 Spring에서는 다 자동으로 들어간다.
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			USER_ID가 첫 번째 ?라서 1번. 그 다음부터 2, 3, 4, . . . ,11
			preparedStatement.setString(1, userVO.getUserId());
			preparedStatement.setString(2, userVO.getUserName());
			preparedStatement.setString(3, userVO.getUserPassword());
			preparedStatement.setString(4, userVO.getUserPhone());
			preparedStatement.setString(5, userVO.getUserNickname());
			preparedStatement.setString(6, userVO.getUserEmail());
			preparedStatement.setString(7, userVO.getUserAddress());
			preparedStatement.setString(8, userVO.getUserBirthDate());
			preparedStatement.setString(9, userVO.getUserGender());
			preparedStatement.setString(10, userVO.getUserRecommenderId());
			preparedStatement.setString(11, userVO.getUserJob());
//			SELECT가 아닌 INSERT라서 executeUpdate()
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
//			무슨 예외인지 출력해서 확인하는 방법
//			Exception 객체 e를 출력하면 된다
			System.out.println(e);
			System.out.println("insert()에서 쿼리문 오류");
			
		} finally {
			try {
//				결과 테이블이 따로 존재하지 않아서 resultSet에 담지 않았기 때문에
//				resultSet을 닫아 줄 필요가 없음
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
//				강제 종료
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
//	로그인
	public int login(String userId, String userPassword) {
//		로그인이 성공할 경우 PK값인 USER_NUMBER를 리턴하기 위한 쿼리
		String query = "SELECT USER_NUMBER FROM TBL_USER WHERE USER_ID = ? AND USER_PASSWORD = ?";

		//		resultSet에서 가져온 정수 값을 저장하기 위해 userNumber를 선언 후 초기화
		int userNumber = 0;
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPassword);
//			SELECT라서 executeQuery()
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userNumber = resultSet.getInt("USER_NUMBER");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리문 오류");
		} finally {//close할 영역
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userNumber;
	}
	
//	암호화
	public String encrypt(String password) {
		String encryptedPassword = "";
		for (int i = 0; i < password.length(); i++) {
//			입력받은 password를 하나씩 자르고 아스키코드를 변환하기 위해 KEY을 곱해준다
//			정수로 자동 변환된 값을 char타입으로 강제 형변환해서 연결 
			encryptedPassword += (char)(password.charAt(i) * KEY);
		}
		return encryptedPassword;
	}
	
//	회원탈퇴
	public void delete(int userNumber) {
//		실행할 쿼리문
		String query = "DELETE FROM TBL_USER WHERE USER_NUMBER = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			USER_NUMBER가 NUMBER타입이니 setInt
			preparedStatement.setInt(1, userNumber);
//			SELECT가 아닌 DELETE이므로 executeUpdate()
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
//	아이디 찾기
	public String findId(String userPhone) {
//		쿼리문의 실행 결과를 담을 userId 선언
		String userId = null;
		String query = "SELECT USER_ID FROM TBL_USER WHERE USER_PHONE = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhone);
//			SELECT라서 executeQuery()
			resultSet = preparedStatement.executeQuery();
//			입력받은 userPhone이 테이블에 존재하지 않으면 결과가 null이기 때문에
//			false가 나올 수 있음
			if(resultSet.next()) {
//				결과 행이 어차피 USER_ID 1개니까 인덱스는 1
				userId = resultSet.getString(1);
			}
			
		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userId;
	}
	
//	비밀번호 변경
	public void updateUserPassword(String userId, String userPassword) {
		String query = "UPDATE TBL_USER SET USER_PASSWORD = ? WHERE USER_ID = ?";
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			비번 업데이트해줘
			preparedStatement.setString(1, userPassword);
//			아이디가 일치하는 애 꺼
			preparedStatement.setString(2, userId);
//			SELECT가 아닌 UPDATE라서 executeUpdate()
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("updateUserPassword() 쿼리 오류");
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
//	회원정보 수정
//	수정할 값의 입력이 완료된 userVO 객체를 매개변수로 받아온다
	public void update(UserVO userVO) {
		String query = "UPDATE TBL_USER "
				+ "SET USER_NAME=?, USER_PASSWORD=?, USER_PHONE=?, USER_NICKNAME=?, USER_ADDRESS=?, USER_BIRTH_DATE=?, USER_GENDER=? , USER_RECOMMENDER_ID=?, USER_JOB=?"
				+ "WHERE USER_NUMBER = ?";
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			1번째 ?인 USER_NAME에는 userVO에서 userName을 getUserName()으로 가져와서 저장
			preparedStatement.setString(1, userVO.getUserName());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserPhone());
			preparedStatement.setString(4, userVO.getUserNickname());
			preparedStatement.setString(5, userVO.getUserAddress());
			preparedStatement.setString(6, userVO.getUserBirthDate());
			preparedStatement.setString(7, userVO.getUserGender());
			preparedStatement.setString(8, userVO.getUserRecommenderId());
			preparedStatement.setString(9, userVO.getUserJob());
//			10번째 ?인 USER_NUMBER에는 userVO에서 userNumber를 getUserNumber()로 가져와서 저장
			preparedStatement.setInt(10, userVO.getUserNumber());
//			SELECT가 아닌 UPDATE라서 executeUpdate();
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("update() 쿼리 오류");
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
	
//	회원정보 조회
//	회원정보 전체를 리턴해야하므로 리턴타입은 UserVO
//	회원확인을 위해 PK인 USER_NUMBER에 전달할 userNumber를 받아옴
	public UserVO selectUser(int userNumber) {
		String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB FROM TBL_USER "
				+ "WHERE USER_NUMBER = ?";
//		DATE 타입과 String 타입 사이의 format 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int i = 0;
//		리턴할 UserVO 객체 선언
		UserVO userVO = new UserVO();
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userNumber);
			resultSet = preparedStatement.executeQuery();
//			입력받은 userNumber가 테이블에 존재하지 않는 회원번호일 경우 오류가 날 수 있기 때문에
//			true일 때만 들어오게 처리
			if(resultSet.next()) {
//			행을 가져왔으니 그 행의 첫번 째 열부터 차례대로 가져와서 userVO에 저장 
			userVO.setUserNumber(resultSet.getInt(++i));
			userVO.setUserId(resultSet.getString(++i));
			userVO.setUserName(resultSet.getString(++i));
			userVO.setUserPassword(resultSet.getString(++i));
			userVO.setUserPhone(resultSet.getString(++i));
			userVO.setUserNickname(resultSet.getString(++i));
			userVO.setUserEmail(resultSet.getString(++i));
			userVO.setUserAddress(resultSet.getString(++i));
//			resultSet.getString(++i)를 format에 맞춰 DATE으로 변환 후 다시 format에 맞춰서 String으로 변환
//			변환된 resultSet.getString(++i)이 userVo에 저장
//			변환 때 생기는 ParseException과 resultSet이 null일 때 생기는 NullpointerException을  Exception으로 한번에 예외처리
			try {userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));} catch (Exception e) {;}
			userVO.setUserGender(resultSet.getString(++i));
			userVO.setUserRecommenderId(resultSet.getString(++i));
			userVO.setUserJob(resultSet.getString(++i));
			}else {
				System.out.println("존재하지 않는 회원번호입니다");
			}
		} catch (SQLException e) {
			System.out.println("updateUser() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userVO;
	}
	
	
//	추천수
	public int getTotalOfRecommender(String userId) {
		String query = "SELECT COUNT(USER_RECOMMENDER_ID) FROM TBL_USER WHERE USER_RECOMMENDER_ID = ?";
		//리턴값을 저장할 변수 선언
		int count = 0;
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
//			SELECT라서 executeQuery();
			resultSet = preparedStatement.executeQuery();
//			USER_RECOMMENTDER_ID와 userId가 일치하는 경우가 있다면 if문 안으로 들어감
			if(resultSet.next()) {
//				COUNT(USER_RECOMMENTDER_ID)가 count에 저장됨
				count = resultSet.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return count;
	}
	
//	나를 추천한 사람
//	추천한 사람이 몇 명일지 모르니 ArrayList<UserVO>로 리턴
	public ArrayList<UserVO> selectRecommenders(String userId){
		String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB FROM TBL_USER "
				+ "WHERE USER_RECOMMENDER_ID = ?";
//		리턴할 ArrayList 선언
		ArrayList<UserVO> recommenders = new ArrayList<>();
//		format 설정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int i = 0;
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
//			resultSet을 모두 소진할 때까지 반복
			while(resultSet.next()) {
//				다음 반복이 시작하면 i를 초기화
				i = 0;
				UserVO userVO = new UserVO();
				userVO.setUserNumber(resultSet.getInt(++i));
				userVO.setUserId(resultSet.getString(++i));
				userVO.setUserName(resultSet.getString(++i));
				userVO.setUserPassword(resultSet.getString(++i));
				userVO.setUserPhone(resultSet.getString(++i));
				userVO.setUserNickname(resultSet.getString(++i));
				userVO.setUserEmail(resultSet.getString(++i));
				userVO.setUserAddress(resultSet.getString(++i));
				try {userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));} catch (Exception e) {;}
				userVO.setUserGender(resultSet.getString(++i));
				userVO.setUserRecommenderId(resultSet.getString(++i));
				userVO.setUserJob(resultSet.getString(++i));
//				정보가 저장된 userVO를 ArrayList에 저장
				recommenders.add(userVO);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return recommenders;
	}
	
//	내가 추천한 사람
	public UserVO getMyRecommender(String userId) {
		String query = "SELECT USER_NUMBER, USER_ID, USER_NAME, USER_PASSWORD, USER_PHONE, USER_NICKNAME, USER_EMAIL, USER_ADDRESS, USER_BIRTH_DATE, USER_GENDER, USER_RECOMMENDER_ID, USER_JOB " +
				"FROM TBL_USER WHERE USER_ID = " + 
				"(" +
					"SELECT USER_RECOMMENDER_ID FROM TBL_USER " + 
					"WHERE USER_ID = ?" +
				")";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVO = new UserVO();

		int i = 0;
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
//			SELECT라서 executeQuery()
			resultSet = preparedStatement.executeQuery();
//			가져올 행이 없으면 false
			if(resultSet.next()) {
				userVO.setUserNumber(resultSet.getInt(++i));
				userVO.setUserId(resultSet.getString(++i));
				userVO.setUserName(resultSet.getString(++i));
				userVO.setUserPassword(resultSet.getString(++i));
				userVO.setUserPhone(resultSet.getString(++i));
				userVO.setUserNickname(resultSet.getString(++i));
				userVO.setUserEmail(resultSet.getString(++i));
				userVO.setUserAddress(resultSet.getString(++i));
				try {userVO.setUserBirthDate(sdf.format(sdf.parse(resultSet.getString(++i))));} catch (Exception e) {;}
				userVO.setUserGender(resultSet.getString(++i));
				userVO.setUserRecommenderId(resultSet.getString(++i));
				userVO.setUserJob(resultSet.getString(++i));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userVO;
	}
	
//	회원가입된 전체 회원 수
	public int getTotalUserCount() {
		//USER_ID는 UK라 중복이 없기 때문에 COUNT의 기준으로 삼았다.
		String query = "SELECT COUNT(USER_ID) FROM TBL_USER";
//		리턴값 저장할 변수 선언
		int number = 0;
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement =connection.prepareStatement(query);
//			SELECT라서 executeQuery()
			resultSet = preparedStatement.executeQuery();
//			회원이 아무도 없어도 0이라는 값이 나오기 때문에 next()가 무조건 true
//			if문으로 검사할 필요없음
			resultSet.next();
//			어차피 열이 하나라서 그냥 1 넣어줌
			number = resultSet.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getUserCount() 쿼리문 오류");
		}finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return number;
	}
}



















