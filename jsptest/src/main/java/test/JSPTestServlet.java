package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/jsptest")
public class JSPTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String id = request.getParameter("id");
		String menu = request.getParameter("menu");
		int page = Integer.parseInt(request.getParameter("page"));
		
		
		if(id.equals("admin") && menu.equals("memberlist")) {
			
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.getMemberList(page, 4);
		
			for (MemberDTO dto : list) {
				System.out.println(dto);
			}
			
			request.setAttribute("result", list);
			RequestDispatcher rd = request.getRequestDispatcher("/memberlist.jsp");
			rd.forward(request, response);
			
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>잘못된 입력입니다.</h1>");
			
		}
		
		

		
		
	}

}
