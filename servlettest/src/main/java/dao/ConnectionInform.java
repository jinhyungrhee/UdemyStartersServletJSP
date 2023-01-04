package dao;

// 연결 정보만 모아놓은 클래스
// 데이터 연결정보만 바뀌면 ConenctionInform 클래스만 바꾸면 됨!
public class ConnectionInform {
	
	// 어느 클래스에서든 사용할 수 있도록 static 설정
	public final static String DRIVER_CLASS = "org.mariadb.jdbc.Driver";
	public final static String JDBC_URL = "jdbc:mariadb://localhost:3306/memberdb";
	public final static String USERNAME = "jdbc";
	public final static String PASSWORD = "jdbc";

	public static void main(String[] args) {
		
		
		
	}

}
