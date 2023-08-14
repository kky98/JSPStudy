package servlet01.com.future;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDo
 */
@WebServlet("/second")
public class ServletDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDo() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("요청이 왔을때 처음 실행되는 부분");
	}
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("종료시 실행되는 부분");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get 방식으로 요청이 왔을때 실행되는 부분 
		System.out.println("doGet");
		System.out.println(request.getParameter("nm"));// 전달 받은 값 출력
		response.getWriter().append("요청받은 내용 전달: ").append(request.getParameter("nm")).append("님 ^^ ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 요청이 왔을때 실행되는 부분 
		System.out.println("doPost");
		request.setCharacterEncoding("utf-8"); // 요청받은내용
		String nm = request.getParameter("nm");
		//response 응답 
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('" + nm + " 님 반가워요^^ ');");
		out.println("</script>");
		doGet(request, response);
	}

}
