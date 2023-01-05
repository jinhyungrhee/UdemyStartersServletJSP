package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bank")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// loginSession에서 만든 session을 가져옴 (= 한번 만들어진 session을 여러 servlet에서 공유)**
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 로그인 id 가져와서 공유
		if( session.getAttribute("sessionid") != null ) {
			out.println("<h1>" + session.getAttribute("sessionid") 
			+ " 님 인증되셨습니다.(5분간 유효합니다.)</h1>");
			// 세션 제거
			session.setMaxInactiveInterval(60*5); // 5분만 유효
			
		}
		else {
			out.println("<h1><a href='loginsession?id=test&pw=1111'>로그인</a> 먼저 하세요. 그래야 회원정보를 보여줍니다.</h1>");
			
		}
		
		
		
		
	}

}
