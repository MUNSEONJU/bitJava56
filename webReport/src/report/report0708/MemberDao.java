package report.report0708;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MemberDao {
	DbConnectionPool dbcp;
	
	public void setDbConnectionPool(DbConnectionPool dbcp){
		this.dbcp = dbcp;
	}

	public Member get(int no) throws Exception{
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			con = dbcp.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select mno,name,email,tel,pwd from members where mno = " + no);
			
			Member member = null;
			ArrayList<Member> members = new ArrayList<Member>();
			while(rs.next()){
				member = new Member();
				member.setMno(rs.getInt("mno"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setTel(rs.getString("tel"));
				member.setPwd(rs.getString("pwd"));
			}
			return member;
			
		} catch (Exception e){
			throw e;
		} finally {
			try {	rs.close();	} catch (SQLException e) {	}
			try {	stmt.close();	} catch (SQLException e) {  }
			//try {	con.close(); } catch (SQLException e) {	}
			dbcp.returnConnection(con);
		}
			
	}
	
	public void insert(Member member) throws Exception{
		Connection con=null;
		PreparedStatement stmt = null;
		
		try{
			con = dbcp.getConnection();
			stmt = con.prepareStatement(
					"insert into members(name,email,tel,pwd) values(?,?,?,?)");
			
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getTel());
			stmt.setString(4, member.getPwd());
			
			stmt.executeUpdate();
			
		} catch (Exception e){
			throw e;
		} finally {
			try {	stmt.close();	} catch (SQLException e) {  }
			//try {	con.close(); } catch (SQLException e) {	}
			dbcp.returnConnection(con);
		}
	}
	
	public void delete(int no) throws Exception{
		Connection con=null;
		PreparedStatement stmt = null;
		
		try{
			con = dbcp.getConnection();
			stmt = con.prepareStatement(
					"delete from members where mno=?");
			
			stmt.setInt(1, no);
			
			stmt.executeUpdate();
			
		} catch (Exception e){
			throw e;
		} finally {
			try {	stmt.close();	} catch (SQLException e) {  }
			//try {	con.close(); } catch (SQLException e) {	}
			dbcp.returnConnection(con);
		}
	}
	
	public void update(Member member)throws Exception{
		Connection con=null;
		PreparedStatement stmt = null;
		
		try{
			con = dbcp.getConnection();
			stmt = con.prepareStatement(
					"update members set name = ?, email =?, tel = ?, pwd = ? where mno = ?;");
			
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getTel());
			stmt.setString(4, member.getPwd());
			stmt.setInt(5, member.getMno());
			
			stmt.executeUpdate();
			
		} catch (Exception e){
			throw e;
		} finally {
			try {	stmt.close();	} catch (SQLException e) {  }
			//try {	con.close(); } catch (SQLException e) {	}
			dbcp.returnConnection(con);
		}
	}
	
	public ArrayList<Member> load() throws Exception{
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			con = dbcp.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select mno,name,email,tel,pwd from members order by mno desc ");
			
			Member member = null;
			ArrayList<Member> members = new ArrayList<Member>();
			while(rs.next()){
				member = new Member();
				member.setMno(rs.getInt("mno"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setTel(rs.getString("tel"));
				member.setPwd(rs.getString("pwd"));
				members.add(member);
			}
			return members;
			
		} catch (Exception e){
			throw e;
		} finally {
			try {	rs.close();	} catch (SQLException e) {	}
			try {	stmt.close();	} catch (SQLException e) {  }
			//try {	con.close(); } catch (SQLException e) {	}
			dbcp.returnConnection(con);
		}
		
  }
	
}
