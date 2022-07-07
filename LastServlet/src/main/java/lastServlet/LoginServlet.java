package lastServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/login2")
public class LoginServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out  = response.getWriter();
		
		String user_id   = request.getParameter("user_id");
		String user_pwd  = request.getParameter("user_pwd");
		
		byeonVO byeonvo = new byeonVO();
		byeonvo.setId(user_id);
		byeonvo.setPwd(user_pwd);
		
		byeonDAO dao = new byeonDAO();
		
		boolean result = 
				
	}

}
