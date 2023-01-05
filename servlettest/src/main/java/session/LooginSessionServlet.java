package session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/loginsession")
//http://ip:port/servlettest/login/1111
//@WebServlet("/login/*")
//@WebServlet("/*")
@WebServlet("*.do") // 확장자만 일치하면 모두 login 서블릿 호출 => '확장자패턴'(URL만 보고 어떤 기능인지 판단)
// 여러 개 url로 1개의 서블릿 호출(맵핑) 
public class LooginSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// 요청 보낸 브라우저에 세션 있는지 확인(최초 요청인지 아닌지?) 
		// true  : 이전 생성되어 있는 session 가져옴 (두 번째 이상 요청)
		// false : 새로운 session 생성 (첫 번쨰 요청)
		HttpSession session = request.getSession();
		
		session.setAttribute("sessionid", id);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id != null && pw != null) {
			out.println("<h1>로그인하셨습니다.</h1>");
			out.println("<h1>사용 가능한 메뉴는 다음과 같습니다.</h1>");
			out.println("<h1><a href='bank'>은행 업무 보기</a></h1>");
			out.println("<h1><a href='mypage'>내 정보 보러가기</a></h1>");
			out.println("<h1><a href='boardwriting'>글쓰러 가기</a></h1>");
			out.println("<h1><a href='logout'>로그아웃 하러가기</a></h1>");
			out.println("<h1>로그인 정보 유효 시간은 " + session.getMaxInactiveInterval() + " 초입니다.</h1>"); // 초단위
			
		}
		else {
			out.println("<h1>로그인 한적이 없습니다.</h1>");
		}
		out.println();
		
	}

}
