package lastServlet;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
public class LoginImpl implements HttpSessionListener {

	   String user_id;
	    String user_pw;
	    static int total_user=0;
		
		
		
	    public LoginImpl() {
	        // TODO Auto-generated constructor stub
	    }
	    public LoginImpl(String user_id,String user_pw) {
	    	this.user_id=user_id;
	    	this.user_pw=user_pw;
	    	
	    }
		
		public void sessionCreated(HttpSessionEvent arg0) {
			System.out.println("세션 생성");
			++total_user;
		}
		public void sessionDestroyed(HttpSessionEvent arg0) {
			System.out.println("세션 소멸");
			--total_user;
		}
	
}
