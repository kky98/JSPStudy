package servlet02.future.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMain extends HttpServlet{
	
	public void service(HttpServletRequest req
			  , HttpServletResponse res) throws IOException {
		System.out.println("main");
//		req.setCharacterEncoding("utf-8"); // 요청받은내용
		String nm = req.getParameter("nm");
		//response 응답 
		res.setContentType("text/html; charset=utf-8");
		res.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('" + nm + " 님 반가워요^^ ');");
		out.println("</script>");
	}
}
