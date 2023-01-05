package forward;

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

@WebServlet("/forward3")
public class ForwardTest3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// forward3?menu=memberlist&page=3
		String menu = request.getParameter("menu");
		String page = request.getParameter("page");
		if(menu.equals("memberlist")) {
			// 한 페이지당 출력 멤버수 = 4
			// MemberDAO 객체 생성
			// getMemberList 메서드 호출 - 결과리턴
			// forward4 속성으로 전달(setAttribute)
			// forward4로 이동 (forward)
			
			MemberDAO dao = new MemberDAO();
			ArrayList<MemberDTO> list = dao.getMemberList(Integer.parseInt(page), 4);
			
			request.setAttribute("members", list); // Object 타입으로 설정
			
			RequestDispatcher rd = request.getRequestDispatcher("/forward4");
			rd.forward(request, response);
			
			
		}
	
	}

}
