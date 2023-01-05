package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
       
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		// 요청 - (요청필터) - 처리 - (응답필터) -  응답
		
		System.out.println("Filter 시작");
		// [요청필터]
		// 모든 서블릿 실행시마다(요청) 서블릿 이름, 요청클라이언트ID 출력 후에 - 서블릿 doGet, doPost
		String servletname =((HttpServletRequest)request).getServletPath();
		String clientip = request.getRemoteAddr(); // 0.0.0.0.
		System.out.println(clientip + " 컴퓨터가 " + servletname + " 을 호출했습니다.");
		
		
		// 서블릿 요청 인코딩 변경 (get방식은 써도 변화X / post방식은 꼭 써야함-한글)
		request.setCharacterEncoding("utf-8");
		
		long start = System.currentTimeMillis();
		// 서블릿 실행 
		chain.doFilter(request, response); // 다른 필터 실행. 다른 필터 없으면 서블릿 실행
		long stop = System.currentTimeMillis();
		
		System.out.println((stop - start) + "실행 소요 시간(1/1000초)");
		
		// [응답필터]
		
	}
	

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
