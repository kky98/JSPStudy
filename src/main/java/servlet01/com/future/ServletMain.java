package servlet01.com.future;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class ServletMain extends HttpServlet{

	@Override 
	protected void service(HttpServletRequest req
			, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("hi");
		res.setContentType("text/html; charset=UTF-8");
		res.setCharacterEncoding("UTF-8"); 
		OutputStream os = res.getOutputStream(); 
		//문자열 출력
		PrintStream out = new PrintStream(os, true); //버퍼는 8k 바이트가되어야 
		                                       //보낼 수 있는데 바로보내려면true
		out.println("main 화면입니다 ^^");
		
	}
}
