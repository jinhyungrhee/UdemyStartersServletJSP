package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

@WebServlet("/updatedb")
public class UpdateDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();	
		String id = (String)session.getAttribute("id");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>회원정보수정</h1>");
		out.println("<form action=\"/servlettest/updatedb\" method=\"post\">");
		out.println("아이디: <input type='text' name='id' value='" + id + "' readonly><br>");
		out.println("암호수정: <input type=\"password\" name=\"pw\"><br>");
		out.println("이름수정: <input type=\"text\" name=\"name\"><br>");
		out.println("이메일수정: <input type=\"text\" name=\"email\"><br>");
		out.println("폰번호수정: <input type=\"text\" name=\"phone\"><br>");
		out.println("주소수정: <input type=\"text\" name=\"address\"><br>");
		out.println("<input type=\"submit\" value=\"수정하기\"></form>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
	
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		map.put("name", name);
		map.put("email", email);
		map.put("phone", phone);
		map.put("address", address);
		
		MemberDAO dao = new MemberDAO();	
		int result = dao.updateMemberAnswer(map);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (result == 1) {
			out.println("<h1>회원 정보 수정에 성공하였습니다 <a href='login_db.html'>로그인하기</a></h1>");
		} 
		else {
			out.println("<h1>회원 정보 수정에 실패하였습니다 <a href='login_db.html'>로그인하기</a></h1>");
		}
		
	}

}
