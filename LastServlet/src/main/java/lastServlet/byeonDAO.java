package lastServlet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class byeonDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public byeonDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java/comp/env");
			dataFactory = (DataSource) envContext.lookup("java/oracle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<byeonVO> listMembers(){
		List<byeonVO> list = new ArrayList<byeonVO>();
		try {
			con=dataFactory.getConnection();
			String query = "select * from byeon_member";
			System.out.println(query);
			pstmt=con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				byeonVO vo = new byeonVO();
				
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	public void delMember(String id) {
		try {
			con=dataFactory.getConnection();
			String query = "delete from byeon_member"+"where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
	public void addMember(byeonVO byeonvo) {
		
		try {
			con=dataFactory.getConnection();
			String id = byeonvo.getId();
			String pwd = byeonvo.getPwd();
			String name = byeonvo.getName();
			String email = byeonvo.getEmail();
			String query = "insert into byeon_member";
			query+="(id,pwd,name,email)";
			query+="values(?,?,?,?)";
			
			pstmt=con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeUpdate();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	 public boolean isExisted(byeonVO byeonVO) {
		 boolean result = false;
		 String id = byeonVO.getId();
		 String pwd = byeonVO.getPwd();
		 
	 }
	}

}
