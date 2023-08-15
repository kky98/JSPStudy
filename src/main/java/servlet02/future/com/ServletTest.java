package servlet02.future.com;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//test 라는 경로로 요청이오면  web.xml에 ServletTest 서블릿을 호출하도록 
// web.xml을 수정해보세요 ^^
public class ServletTest extends HttpServlet{
	public void service(HttpServletRequest req
			  , HttpServletResponse res) throws IOException {
		System.out.println("test 입니다.");
	}
}
