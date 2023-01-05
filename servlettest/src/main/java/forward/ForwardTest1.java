package forward;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forward1")
public class ForwardTest1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//request attribute : request에 정보 추가하는 기능(Map: key-value 구조)
		request.setAttribute("upperid", id.toUpperCase());
		
		// forward(응답) 전에 출력을 시도하면 무시됨!
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out = response.getWriter(); 
		out.println("<h1> forwardTest1 클래스입니다</h1>");
		//out.println("<h1>" + request.getAttribute("upperid") + " 회원님 반갑습니다.</h1>");
		
		// 응답 서블릿 호출 : RequestDispatcher (인터페이스 이므로 다른 객체를 통해서 생성)
		// URL : "웹어플리케이션명포함/~" 
		RequestDispatcher rd = request.getRequestDispatcher("/forward2");
		rd.forward(request, response); // 다른 파일로 "이동" -> 갔다가 다시 돌아오지 않음 (제어가 넘어감)
		out.println("<h1> forwardTest1 클래스입니다</h1>"); // 무시
	
	}

}


