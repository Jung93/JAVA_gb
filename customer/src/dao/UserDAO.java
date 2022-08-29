package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.UserVO;

public class UserDAO {
//	회원의 상태를 정수 값으로 표현
//	탈퇴는 -1, 복구는 0
//	아이디 중복 검사에서 해당 아이디의 중복 여부
//	중복은 1, 사용 가능이면 2
	public static final int DELETED_USER_CODE = -1;
	public static final int RESTORED_USER_CODE = 0;
	public static final int DUPLICATED_ID_CODE = 1;
	public static final int ENABLED_ID_CODE = 2;

//	연결 객체들 생성
	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;

	/**
	 * API 주석. 이 안에 쓰면 다 보인다.
	 * @param userId
	 * @return
	 *	DELETED_USER_CODE = -1;<br>
	  	RESTORED_USER_CODE = 0;<br>
		DUPLICATED_ID_CODE = 1;<br>
		ENABLED_ID_CODE = 2;<br>
	 */
//	아이디 중복검사	
	public int checkId(String userId) {
		//userId가 일치하는 회원의 현재 가입 상태를 확인하는 쿼리문
		String query = "select userStatus from tbl_user where userId = ?";
		//
		int code = 0;
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			resultSet = preparedStatement.executeQuery();
//			resultSet.next()가 있다는 건 중복되는 아이디가 존재한다는 의미
			if(resultSet.next()) {
//				따라서 code에는 중복을 의미하는 DUPLICATED_ID_CODE = 2를 저장
				code = DUPLICATED_ID_CODE;
//				하지만 userStatus가 탈퇴를 의미하는 DELETED_USER_CODE인 -1과 같다면
				if(resultSet.getInt(1) == DELETED_USER_CODE) {
//				해당 유저는 이미 탈퇴한 유저이기 때문에 code에 DELETED_USER_CODE를 대입
					code = DELETED_USER_CODE;
				}
			}else {
//				첫 번째 if문에 들어가지 않았다면 중복이 아예 없다는 것이므로 ENABLED_ID_CODE 대입
				code = ENABLED_ID_CODE;
			}

		} catch (SQLException e) {
			System.out.println("checkId()에서 쿼리문 오류");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
//		userStatus를 의미하는 정수값을 리턴
		return code;
	}

//	입력받은 핸드폰번호와 일치하는 번호를 가진 회원수가 3명인지 확인
	private boolean check(String userPhoneNumber) {
		boolean check = false;
//		번호가 일치하는 회원수를 측정하는 쿼리문
		String query = "select count(userPhoneNumber) result from tbl_user where userPhoneNumber = ?";
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhoneNumber);
			resultSet = preparedStatement.executeQuery();
//			false가 나올리는 없지만 혹시 모를 오류 방지
			if (resultSet.next()) { 
//				컬럼은 어차피 한개라서 getInt(1)과 같음
//				해당 카운트가 3개 미만이면 true
//				3개면 false
				check  = resultSet.getInt("result") < 3;
			}
			
		
					
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리문 오류");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
//		같은 번호로 3번 가입한 사람은 false, 나머지는 true 리턴
		return check;
	}
	
//	회원가입
	public boolean insert(UserVO userVO) {
//		같은 번호로 3번 가입한 사람은 더 이상 진행하지 않고 바로 false 리턴
		if(!check(userVO.getUserPhoneNumber())) { return false; }
		String query = "insert into tbl_user "
				+ "(userId, userPassword, userName, userAge, userPhoneNumber, userBirth) "
				+ "values(?, ?, ?, ?, ?, ?)";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserId());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserName());
			preparedStatement.setInt(4, userVO.getUserAge());
			preparedStatement.setString(5, userVO.getUserPhoneNumber());
			preparedStatement.setString(6, userVO.getUserBirth());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("insert()에서 쿼리문 오류");

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
//		여기까지 왔다는 거 자체가 회원가입 성공이므로 바로 true 리턴
		return true;
	}

//	로그인
	public int login(String userId, String userPassword) {
//		아이디, 비번이 일치하는 회원의 회원번호와 상태를 가져오는 쿼리문
		String query = "select userNumber, userStatus from tbl_user where userId = ? and userPassword =?";
//		login 성공 시 리턴할 userNumber 선언
		int userNumber = 0;

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPassword);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
//				일치하는 컬럼이 1개라서 getInt(1)과 같음
				userNumber = resultSet.getInt("userNumber");
//				회원의 상태가 탈퇴 상태인지 확인
				if(resultSet.getInt(2) == DELETED_USER_CODE) {
//					탈퇴 상태라면 userNumber에 -1 저장
					userNumber = DELETED_USER_CODE;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리문 오류");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userNumber;
	}

//	아이디 찾기
	public ArrayList<UserVO> findId(String userPhoneNumber) {

		String query = "select userNumber, userId, userPhoneNumber from tbl_user where userPhoneNumber = ?";
//		아이디가 여러 개이고 몇 개인지 모르니까 ArrayList 타입으로 리턴
		ArrayList<UserVO> users = new ArrayList<UserVO>();

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhoneNumber);
			resultSet = preparedStatement.executeQuery();
//			번호가 일치하는 결과만큼 반복
			while (resultSet.next()) {
//				번호가 일치하는 회원의 회원번호, 아이디, 핸드폰번호를 users에 저장
				UserVO userVO = new UserVO();
				userVO.setUserNumber(Integer.valueOf(resultSet.getString(1)));
				userVO.setUserId(resultSet.getString(2));
				userVO.setUserPhoneNumber(resultSet.getString(3));

				users.add(userVO);
			}

		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
//		번호가 일치하는 회원의 정보들을 리턴
		return users;
	}

//	회원 정보 전체 수정
	public void update(UserVO userVO) {
		String query = "update tbl_user " + "set userName=?, userPassword=?, userPhoneNumber=?, userAge=?, userBirth=? "
				+ "where userNumber = ?";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, userVO.getUserName());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserPhoneNumber());
			preparedStatement.setInt(4, userVO.getUserAge());
			preparedStatement.setString(5, userVO.getUserBirth());
//			where절에 있는 ?
			preparedStatement.setInt(6, userVO.getUserNumber());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update() 쿼리 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

//	회원 전체 정보 조회
	public UserVO selectUser(int userNumber) {
		String query = "select userNumber, userId, userPassword, userName, userAge, userPhoneNumber, userStatus, userBirth from tbl_user "
				+ "where userNumber=?";

		int i = 0;
//		리턴할 UserVO 타입의 객체
		UserVO userVO = new UserVO();
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userNumber);
			resultSet = preparedStatement.executeQuery();
// 			일치하는 회원의 정보를 userVO 객체에 저장
			if (resultSet.next()) {
				userVO.setUserNumber(resultSet.getInt(++i));
				userVO.setUserId((resultSet.getString(++i)));
				userVO.setUserPassword(resultSet.getString(++i));
				userVO.setUserName(resultSet.getString(++i));
				userVO.setUserAge(resultSet.getInt(++i));
				userVO.setUserPhoneNumber(resultSet.getString(++i));
				userVO.setUserStatus(resultSet.getInt(++i));
				userVO.setUserBirth(resultSet.getString(++i));
			}
		} catch (SQLException e) {
			System.out.println("selectUser() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userVO;
	}

//	회원탈퇴
	public void delete(int userNumber) {
//		회원의 가입 상태를 변경
		String query = "update tbl_user set userStatus=? where userNumber= ?";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			탈퇴하는 회원의 상태를 -1로 변경
			preparedStatement.setInt(1, DELETED_USER_CODE);
			preparedStatement.setInt(2, userNumber);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

//	회원탈퇴 복구
	public void restore(int userNumber) {
//		탈퇴를 번복, 복구하기 위해 update해서 userStatus를 변경
		String query = "update tbl_user set userStatus=? where userNumber = ?";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			회원 상태를 0으로 변경
			preparedStatement.setInt(1, RESTORED_USER_CODE);
			preparedStatement.setInt(2, userNumber);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("restore() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	
//	핸드폰번호로 가입한 전체 회원 정보 조회
//	동일한 핸드폰으로 3개까지 가입이 가능하기 때문에 ArrayList
	public ArrayList<UserVO> findUsersByUserPhoneNumber(String userPhoneNumber) {
//		보유한 아이디들의 가입 상태까지 확인하기 위해 userStatus를 가져옴
		String query = "select userNumber, userId, userName, userAge, userPhoneNumber, userBirth, userStatus from tbl_user "
				+ "where userPhoneNumber = ?";
		ArrayList<UserVO> users = new ArrayList<UserVO>();
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhoneNumber);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
//				UserVO타입의 객체를 ArrayList에 저장하기 위함
				UserVO userVO = new UserVO();
				
				userVO.setUserNumber(resultSet.getInt(1));
				userVO.setUserId(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserAge(resultSet.getInt(4));
				userVO.setUserPhoneNumber(resultSet.getString(5));
				userVO.setUserBirth(resultSet.getString(6));
				userVO.setUserStatus(resultSet.getInt(7));
				users.add(userVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return users;
	}
}























