package servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "loadConfig", urlPatterns = { "/loadConfig" }, loadOnStartup=1) //1
public class LoadAppConfig extends HttpServlet {
	private ServletContext context;  //2

	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoadAppConfig의 init 메서드 호출 ");
		context = config.getServletContext(); //3
		
		String menu_member = context.getInitParameter("menu_member"); //4번
		String menu_order = context.getInitParameter("menu_order");   //4번
		String menu_goods = context.getInitParameter("menu_goods");   //4번
		
		context.setAttribute("menu_member", menu_member);             //5번
		context.setAttribute("menu_order", menu_order);               //5번
		context.setAttribute("menu_goods", menu_goods);               //5번
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String menu_member = (String) context.getInitParameter("menu_member"); //7번
		String menu_order = (String) context.getInitParameter("menu_order");   //7번
		String menu_goods = (String) context.getInitParameter("menu_goods");   //7번
		
		out.print("<html><body>");
		out.print("<table border=1 cellspacing=0><tr>메뉴이름</tr>");
		out.print("<tr><td>"+menu_member+"</td></tr>");
		out.print("<tr><td>"+menu_order+"</td></tr>");
		out.print("<tr><td>"+menu_goods+"</td></tr>");
		out.print("</body></html>");
		
	}

}
