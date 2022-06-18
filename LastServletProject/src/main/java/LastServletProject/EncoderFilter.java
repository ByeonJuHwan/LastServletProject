package LastServletProject;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;


@WebFilter("/*")
public class EncoderFilter implements Filter {

	
	public void destroy() {
		System.out.println("destroy 호출");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		request.getParameter("utf-8");
		String context = ((HttpServletRequest)request).getContextPath();
		String pathinfo = ((HttpServletRequest)request).getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		String mesg = "Context 정보"+context
					+"\n URI 정보"+pathinfo
					+"\n 물리적 경로 :"+realPath;
		
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init 메서드 호");
	}

}
