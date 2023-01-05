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

@WebServlet("/deletedb")
public class DeleteDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		MemberDAO dao = new MemberDAO();
		int check = dao.deleteMember(id);
		
		PrintWriter out = response.getWriter();
	
		if (check == 1) {
			out.println("<h1>회원 탈퇴에 성공하였습니다.</h1>");
		}
		else {
			out.println("<h1>회원 탈퇴에 실패하였습니다.</h1>");
		}
		
	}

}
