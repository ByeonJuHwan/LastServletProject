package CookieAPI;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


//@WebServlet("/login")
public class SessionTest4 extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		if(session.isNew()) {
			
			if(user_id != null) {
				session.setAttribute("user_id", user_id);
				String url = response.encodeURL("login");
				out.print("<a href="+url+">로그인상태 확인</a>");
			}else {
				out.print("<a href='login2.html'>다시 로그인해주세요!</a>");
				session.invalidate();
			}
		}else {
			user_id = (String) session.getAttribute("user_id");
			if(user_id != null && user_id.length() !=0) {
				out.print("안녕하세요"+user_id+"님!!!!");
			}else {
				out.print("<a href='login2.html'>다시로그인하세요!!</a>");
				session.invalidate();
			}
		}

	
	
	}
}