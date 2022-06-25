package DBex;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection2 {

	public static void main(String[] args) {
	       String url ="jdbc:oracle:thin:db20220615202734?TNS_ADMIN=/Users/byeonjuhwan/Desktop/Wallet_oracle";
	       String userid="admin";
	       String pwd ="Quswnghks99*";
	       
	     
	       //드라이버 로딩 
	       try {
	    	    //oracle DB연결 드라이버 로딩
	    	    Class.forName("oracle.jdbc.OracleDriver");//
	    	    System.out.println("드라이버 로딩 성공");
	       }catch(Exception e) {
	    	    e.printStackTrace();
	       }
	       
	       //DBMS와 연결
	       try {
	    	       System.out.println("데이터베이스 연결 준비......");
	    	       Connection con =DriverManager.getConnection(url, userid, pwd);
	    	       if(con!=null) {
	    	    	   System.out.println("데이터베이스 연결 성공...");
	    	       }
	       }catch(Exception e) {
	    	   e.printStackTrace();
	       }
		}
	}