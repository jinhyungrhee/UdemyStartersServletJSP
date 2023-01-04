package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8081/servlettest/loginprocess
@WebServlet("/loginprocess")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.html(id, pw)
		// post는 response body에 utf-8 설정이 되어있지 않음!
		request.setCharacterEncoding("utf-8"); // post 방식에만 필요!
		String id = request.getParameter("id");
		
		if(id != null && !id.equals("")) {
			System.out.println(id.equals("servlet"));			
		}
		
		String pw = request.getParameter("pw");
		//String title = request.getParameter("title"); // 하나의 변수에 하나의 값 전달
		String[] title = request.getParameterValues("title"); // 하나의 변수에 여러 개의 값 전달
		// 여러 개의 값 전달
		// select multiple=multiple, input type=checkbox
		
		// id pw
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + id + " 회원님 환영합니다</h1>");
		out.println("<h1>" + pw + " 암호를 입력하셨습니다.</h1>");
		for (String t : title) {
			out.println("<h1>" + t + " 을 선택하셨습니다.</h1>");			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println(request.getMethod());
		request.setCharacterEncoding("utf-8"); // post 방식에만 필요!
		doGet(request, response); // doPost 내부에서 doGet을 호출하면 둘다 동시에 처리 가능!
		
	}
		
}
