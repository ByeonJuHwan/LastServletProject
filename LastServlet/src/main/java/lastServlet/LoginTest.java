package lastServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginTest extends HttpServlet {
	
	ServletContext context = null;
	List user_list = new ArrayList(); // 로그인한 접속자 ID를 저장하는 Araay!!

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		context=getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session  = request.getSession();
		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pwd");
		LoginImpl loginUser = new LoginImpl(id,pwd);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(id);
			context.setAttribute("user_list", user_list);
		}
		out.println("<html><body>");
		out.println("아이디는"+loginUser.user_id+"<br>");
		out.println("총 접속자수는"+LoginImpl.total_user+"<br><br>");
		out.println("접속 아이디:<br>");
		
		List list = (ArrayList)context.getAttribute("user_list");
		for(int i=0; i<list.size();i++) {
			out.println(list.get(i)+"<br>");
			
		}
		out.println("<a href='logout?id="+id+"'>로그아웃</a>");
		out.println("</body></html>");
	}

}
