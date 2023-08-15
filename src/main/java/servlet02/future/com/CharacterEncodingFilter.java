package servlet02.future.com;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
		@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
			System.out.println("before filter");
			request.setCharacterEncoding("utf-8");// 모든 서블릿에적용
			chain.doFilter(request, response);// 다음 필터나 다음서블릿으로전달
			System.out.println("after filter");
	}

}
