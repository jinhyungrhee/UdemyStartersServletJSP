package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 1. 요청 정보 추출
		//request.setCharacterEncoding("utf-8"); // 한글일 경우 -> 필터가 변경하도록 설정
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// 응답 준비
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 필수 데이터 입력하지 않은 경우
		if (id == null || pw == null) {
			// 다시 돌아가서 입력하라
			out.println("<h1>필요 정보를 모두 입력하세요</h1>");
			out.close();
		}
		
		// [세션] 사용
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		
		
		// 2. 로그인 처리 - jdbc
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id, pw);
		
		
		// 3. 정상 로그인 / 암호 다시 입력 / 회원가입대상 응답
		/* dto id, pw 저장 상태
		 * dto id 저장, pw null 상태
		 * dto null 상태
		 * */
		String result = "";
		if (dto != null && dto.getPw() != null) {
			result = "<h1>" + id + " 회원님 정상 로그인되었습니다.</h1></br>"
					+ "<form action='/servlettest/updatedb' method='get'><input type=submit value='회원정보수정'></form>"
					+ "<form action='/servlettest/deletedb' method='post'><input type=submit value='회원탈퇴'></form>";
		}
		else if(dto != null && dto.getPw() == null) {
			result = "<h1>" + id + " 회원님으로서 인증되지 않았습니다. "
					+ "<a href='login_db.html'>다시로그인하러가기</a></h1>";
		}
		else if(dto == null) {
			result = "<h1>" + id + " 회원가입되지 않았습니다. "
					+ "<a href='insert_db.html'>회원가입하러가기</a></h1>";
		}
		out.println(result);
		
		
	}

}
