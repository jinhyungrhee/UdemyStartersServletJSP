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

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String menu = request.getParameter("menu");
		
		if(menu.equals("memberlist")) {
			
			int page = Integer.parseInt(request.getParameter("page"));
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.getMemberList(page, 4);
		
			for (MemberDTO dto : list) {
				System.out.println(dto);
			}
			
			request.setAttribute("result", list);
			RequestDispatcher rd = request.getRequestDispatcher("/memberlist.jsp");
			rd.forward(request, response);
			
		}
		else if(menu.equals("member")) {
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = dao.getMember(id, pw);
			
			request.setAttribute("result", dto); // Object 저장
			RequestDispatcher rd = request.getRequestDispatcher("/member.jsp");
			rd.forward(request, response);
			
				
		}
		else if(menu.equals("insertform")) {
			RequestDispatcher rd = request.getRequestDispatcher("/insert_db.html");
			rd.forward(request, response);
		}
		
		else if(menu.equals("insertprocess")) {
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			
			MemberDAO dao = new MemberDAO();
			MemberDTO dto = new MemberDTO(id, pw, name, email, phone, address);
			int result = dao.insertMember(dto);
			
			request.setAttribute("result", result);
			request.setAttribute("dto", dto);
			RequestDispatcher rd = request.getRequestDispatcher("/insertresult.jsp");
			rd.forward(request, response);
			
			
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<h1>잘못된 입력입니다.</h1>");
			
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
