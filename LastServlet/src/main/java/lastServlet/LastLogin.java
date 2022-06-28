package lastServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/lastlogin")
public class LastLogin extends HttpServlet {
	
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		if((id!=null&&id.equals("byeon"))&&(pwd!=null&&pwd.equals("0111"))) {
			out.println("<html><body>");
			out.println("<h1>관리자님 환영합니다!!</h1>");
			out.println("<form method='get' action='admin'>");
			out.println("<br><br>");
			out.println("<button type='submit' value='회원관리'>");
			out.println("<input type='hidden' name='cancle' value='delMember'/>");
			out.println("회원관리</button>");
			out.println("</body></html>");
			
		}else {
			out.print("<h1>"+id+"님 환영합니다!!</h1>");
		}
		
	}
	
		
	

}
