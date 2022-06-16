package pro10;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/get")
public class GetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charshet=utf-8");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		HttpSession sess= request.getSession();
		
		String ctxMesg = (String)ctx.getAttribute("context");
		String sesMesg = (String)sess.getAttribute("session");
		String reqMesg = (String)request.getAttribute("request");
		out.print("context값 : "+ctxMesg+"<br>");
		out.print("session의 값 :"+sesMesg+"<br>");
		out.print("request의 값 :" +reqMesg+"<br>");
		
		
	}

}
