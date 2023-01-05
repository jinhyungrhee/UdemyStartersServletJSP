package forward;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Spring DI/IOC/AOP/MVC
// login.html은 반드시 나(서블릿)를 통해 호출 - "나를 통해서 시작하라"
@WebServlet("/ForwardHTML")
public class ForwardHTML extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// FORWARD시 서버 내부의 같은 어플리케이션 내부 파일들은 얼마든지 이동 가능
		// => 클라이언트는 이 서블릿을 호출하고 서블릿에서 login.html에 접근
		System.out.println("클라이언트는 " + req.getRequestURI() + " 호출하셨습니다.");
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/login.html");
		rd.forward(req, response);
		// INCLUDE()
		// "이 파일을 포함해라" - forward로 보낸다음 다시 돌아와서 추가 응답(출력)
		//rd.include(req, response); 
		// 추가적인 응답(출력) 가능
	}

}
