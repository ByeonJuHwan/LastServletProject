package lastServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/admin")
public class admin extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doHandle(request,response);
	}
	public void doHandle(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		byeonDAO dao = new byeonDAO();
		String cancle  = request.getParameter("cancle");
		
		if(cancle!=null && cancle.equals("cancle")) {
			String id =request.getParameter("id");
			dao.delMember(id);
		}
		List<byeonVO> list = dao.listMembers();
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>사는곳</td><td>가입일</td><td>삭제</td></tr>");
		for(int i =0;i<list.size();i++) {
			byeonVO byeonvo = (byeonVO)list.get(i);
			String id = byeonvo.getId();
			String pwd = byeonvo.getPwd();
			String name = byeonvo.getName();
			String email = byeonvo.getEmail();
			
			Date joinDate = byeonvo.getJoinDate();
			out.print("<tr><td>"+id+"</td><td>"+pwd+"</td><td>"+name+"</td><td>"+email+"</td><td>"+joinDate+"</td><td>"+"<a href='/LastServlet/admin?cancle=delMember&id="+id+"'>삭제</a></td></tr>");
			
		}
		out.print("</table></body></html>");
		out.print("<a href='/LastServlet/memberFrom2.jsp'>접속자수 확인</a>"); //회원 관리하기가 아닌 접속자수로 변경
		
	}

}
