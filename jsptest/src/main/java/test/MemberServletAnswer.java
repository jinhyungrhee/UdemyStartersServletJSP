package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/memberanswer")
public class MemberServletAnswer extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 받아서 - 분석 - 결과 어떤 DAO, DTO 화면 제공
		String menu = request.getParameter("menu");
		MemberDAO dao = new MemberDAO(); // JSP 이동 가능
		String jspName = "";
		if(menu == null) { // null 예외처리
			menu = "insertform"; // default : insertform
		}
		else if(menu.equals("memberlist")) {
			int page = Integer.parseInt(request.getParameter("page"));
			ArrayList<MemberDTO> memberlist = dao.getMemberList(page, 3);
			// forward
			request.setAttribute("memberlist", memberlist);
			jspName = "member/memberlist.jsp";
			// jsp에서 받을 때 액션 태그 사용
			// <jsp:useBean id="memberlist" class="java.util.ArrayList" scope="request">
		}
		else if(menu.equals("member")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			MemberDTO dto = dao.getMember(id, pw);
			// dto == null / dto.getPw() == null
			request.setAttribute("member", dto);
			// <jsp:useBean id="member" class="java.util.ArrayList" scope="request">
			jspName = "member/member.jsp";
			
		}
		else if(menu.equals("insertform")) {
			jspName = "member/insert_db.jsp";
		}
		else if(menu.equals("insertprocess")) {
//			String id = request.getParameter("id");
//			String pw = request.getParameter("pw");
//			String name = request.getParameter("name");
//			String email = request.getParameter("email");
//			String phone = request.getParameter("phone");
//			String address = request.getParameter("address");
//			
//			MemberDTO dto = new MemberDTO(id, pw, name, email, phone, address);
//			int result = dao.insertMember(dto);
//			request.setAttribute("dto", dto);
//			request.setAttribute("result", result);
			
			// 모든 forward된 파일 공유
			request.setAttribute("dao", dao);
			// <jsp:useBean id="dao" class="dao.memberDAO", scope=request>
			
			jspName = "member/insertresult.jsp";
			
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(jspName);
		rd.forward(request, response);
	}

}
