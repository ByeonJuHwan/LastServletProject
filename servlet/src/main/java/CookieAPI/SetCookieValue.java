package CookieAPI;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Date d = new Date();
		Cookie c = new Cookie("CookieTest", URLEncoder.encode("JSP프로그래밍 입니다.","utf-8"));
		c.setMaxAge(24*60*60);
		response.addCookie(c);
		out.println("현재시간 : "+d);
		out.println("<br>");
		out.println("문자열을 Cookie 에 저장합니다.");
	}

}
