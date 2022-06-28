package lastServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/userin")
public class UserIn extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dobyeon(request,response);
		
		
	}
	public void dobyeon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		byeonDAO dao = new byeonDAO();
		
		if(command!=null && command.equals("addMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			byeonVO vo = new byeonVO();
			
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setEmail(email);
			dao.addMember(vo);
			
			
		}
		out.print("<html><body>");
		out.print("<h1>회원가입이 완료 되셨습니다. 로그인 해주시기 바랍니다.");
		out.print("<br><br>");
		out.print("<a href='LastServlet/login.html'>로그인창 이동</a>");
	}
}
