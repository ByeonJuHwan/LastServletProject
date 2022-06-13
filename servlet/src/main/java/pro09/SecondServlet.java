package pro09;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("call init method");
	}

	
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("call destroy method");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String user_address=request.getParameter("user_address");
		
		out.print("<html><body>");
		if(user_id!=null && user_id.length()!=0) {
			out.println("이미 로그인 상태입니다!!<br><br>");
			out.println("첫번째 서블릿에서 넘겨준 아이디 :"+user_id+"<br>");
			out.println("첫번째 서블릿에서 넘겨준 비밀번호 :"+user_pwd+"<br>");
			out.println("첫번째 서블릿에서 넘겨준 주소 :"+user_address+"<br>");
			out.println("</body></html>");
		}else {
			out.println("로그인 하지 않았습니다!<br><br>");
			out.println("다시 로그인 하세요!<br>");
			out.println("<a href='/servlet/login.html'>로그인창으로 이동하기</a>");
		}
		
	}

}
