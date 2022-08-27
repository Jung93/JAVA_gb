package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnecter {
	//DB 연동할 때 그냥 클래스 자체를 복붙해서 재사용
	//스키마 관리 계정의 정보만 주의하면 될 듯
	public static Connection getConnection() {
		//connection 객체를 이용하기 위해 선언
		//Connection은 java.sql 에 있는 것만 사용
		Connection connection = null;
		try {
//			연결에 필요한 정보
			//DB를 관리하는 계정의 이름과 비밀번호
			String userName = "hr";
			String password = "hr";
			//이미 정해져있는 경로
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			
//			드라이버를 메모리에 할당
			//형식이 정해져있음
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			정보를 전달하여 연결 객체 가져오기
			//url과 관리계정의 이름과 비밀번호를 담은 변수를 전달
			connection = DriverManager.getConnection(url, userName, password);
			
			System.out.println("연결 성공");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결 실패");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("알 수 없는 오류");
		}
		
		return connection;
	}
}
