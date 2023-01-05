package test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.ConnectionInform;

@WebServlet("/connection")
public class ConnectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			/*
			Class.forName(ConnectionInform.DRIVER_CLASS);
			long start = System.currentTimeMillis();
			
			// connection 만 개 생성
			for (int i = 1; i <= 10000; i++) {
				
				// 1. db 연결
				Connection con = DriverManager.getConnection
				(ConnectionInform.JDBC_URL, ConnectionInform.USERNAME, ConnectionInform.PASSWORD);
				
				// sql 전송
				System.out.println(i +" 번째 maria DB 연결 성공");
				
				con.close(); // 메모리에서 con 삭제 - 즉각적인 삭제X, 삭제 예정 마킹만
			}
			
			long end = System.currentTimeMillis();
			
			// 결과 : 3717 (1/1000초) 소요
			System.out.println((end - start) + " (1/1000초) 소요");
			*/

			// [2]Connection Pool 사용
			Context initContext = new InitialContext(); // context.xml 준비
			Context envContext = (Context)initContext.lookup("java:/comp/env"); // 자바 연관 설정 정보 찾기 (comp - 자바 객체, env - 환경 설정 정보)
			DataSource ds = (DataSource)envContext.lookup("jdbc/mydb");
			
					
			long start = System.currentTimeMillis();
			
			// connection 만 개 생성
			for (int i = 1; i <= 10000; i++) {
				
				// 1. connection pool 하나 빌려오기
				Connection con = ds.getConnection();
				
				// sql 전송
				System.out.println(i +" 번째 maria DB 연결 성공(DataSource 사용)");
				
				con.close(); // connection pool 반납 ( 계속 재사용 )
			}
			
			long end = System.currentTimeMillis();
			
			// 결과 : 3717 (1/1000초) 소요
			System.out.println((end - start) + " (1/1000초) 소요");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
}
