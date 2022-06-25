package LastServletProject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LastMemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public LastMemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envcontext = (Context) ctx.lookup("java/comp/env");
			dataFactory = (DataSource)envcontext.lookup("jdbc/oacle");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<LastMemberVO> listmember(){
		List<LastMemberVO> list = new ArrayList<LastMemberVO>();
		try {
			con=dataFactory.getConnection();
			String query = "select * from byeon_member";
			System.out.println("preparedStatement :" + query);
			pstmt=con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate  = rs.getDate("joinDate");
				
				LastMemberVO vo = new LastMemberVO();
				
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
	
	public void addMember(LastMemberVO membervo) {
		try{
			con = dataFactory.getConnection();
			
			String id = membervo.getId();
			String pwd = membervo.getPwd();
			String name = membervo.getName();
			String email= membervo.getEmail();
			Date joinDate = membervo.getJoinDate();
			
			String query = "insert into byeon_member";
			query+= "(id,pwd,name,email)";
			query+="values(?,?,?,?)";
			System.out.println("preparedStatement :" + query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			pstmt.executeQuery();
			pstmt.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
