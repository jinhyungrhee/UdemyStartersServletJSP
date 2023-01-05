package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/insertdb")
public class InsertDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청 정보 추출
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		System.out.println("아이디 : " + id);
		
		// 응답 준비
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 필수데이터 입력 확인
		if (id.equals("") || pw.equals("") || name.equals("") || email.equals("") || phone.equals("") || address.equals("")) {
			// 다시 돌아가서 입력하라
			out.println("<h1>필요 정보를 모두 입력하세요</h1>");
			out.close();
			return;
		}
		// 전화번호 예외처리
		String pattern = "010\\d{4}\\d{4}";
		System.out.println(phone);
		if (!phone.matches(pattern)) {
			out.println("<h1>전화번호는 010으로 시작해야 합니다</h1>");
			out.close();
			return;
		}
		
		// 회원가입 처리 : DAO DTO 사용
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String indate = formatter.format(calendar.getTime());
		
		MemberDAO dao = new MemberDAO();
		int result = dao.insertMember(new MemberDTO(id, pw, name, email, phone, address, indate));
		
		String output = "";
		if (result == 1) {
			output = "<h1>정상적으로 가입되었습니다. <a href='login_db.html'>로그인하기</a></h1></h1>";
		} else {
			output = "<h1>회원가입에 실패하였습니다. <a href='insert_db.html'>다시회원가입하기</a></h1>";
		}
		
		out.println(output);
		out.close();
		
	
	}

}
