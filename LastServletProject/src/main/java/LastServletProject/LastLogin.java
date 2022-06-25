package LastServletProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/lastlogin")
public class LastLogin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	private void doHandle (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		LastMemberDAO dao = new LastMemberDAO();
		List<LastMemberVO> list = dao.listmember();
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='red'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td></tr>");
		
		for(int i=0; i<list.size(); i++) {
			LastMemberVO membervo = list.get(i);
			String id = membervo.getId();
			String pwd = membervo.getPwd();
			String name = membervo.getName();
			String email = membervo.getEmail();
			Date joinDate = membervo.getJoinDate();
			
			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+ email+"</td><td>"+joinDate+"</td><tr>");
			
		}
		out.println("</table></body></html>");
	}
	
}
