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


@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String ctxMesg = "context에 바인딩됩니다.";
		String sesMesg = "sesstion에 바인딩 됩니다.";
		String reqMesg = "requestd에 바인딩 됩니다.";
		
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		ctx.setAttribute("context", ctxMesg);
		session.setAttribute("session", sesMesg);
		request.setAttribute("request", reqMesg);
		out.print("바인딩을 수행합니다.");
	}

}
