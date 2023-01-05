package url;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//  홈페이지 시작화면 
@WebServlet("/urltest")
public class URLTESTServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// http://ip:port/servlettest/board   -> boardwriting
		// http://ip:port/servlettest/member  -> forward4
		// http://ip:port/servlettest/product -> 없습니다
		
		/*
		 * URL - Uniform Resource Locator : 주소 전체 -> http://ip:port/servlettest/product
		 * URI - Uniform Resource Indicator : 해당 서버 내부 경로 -> /servlettest/product
		 * 
		 * */
		System.out.println(request.getRequestURI());
		String uri = request.getRequestURI();
		String[] uri_arr = uri.split("/");
		String forward_uri = uri_arr[uri_arr.length - 1];
		System.out.println(forward_uri);
		
		if (forward_uri.equals("board")) {
			forward_uri="boardwriting"; // sessionid 세션 정보
			RequestDispatcher rd = request.getRequestDispatcher(forward_uri);
			rd.forward(request, response);
		}
		else if(forward_uri.equals("member")) {
			forward_uri="forward4"; // menu=memberlist&page=?
			RequestDispatcher rd = request.getRequestDispatcher(forward_uri);
			rd.forward(request, response);
		}
		else {
			System.out.println("이름 url이 없습니다.");
		}
		
	}

}
