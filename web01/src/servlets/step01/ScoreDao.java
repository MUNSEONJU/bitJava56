		/** DB Connection Pool 적용 **/
//	- 외부에서 DB 커넥션 관리자를 주입 받는다.
//	- 의존 객체 주입 -> Dependency Injection

package servlets.step01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDao {
	DbConnectionPool dbConnectionPool;
	
	public ArrayList<Score> list() throws Exception { 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 

		try {
			con = dbConnectionPool.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select sno, name, kor, eng, math "
			    + " from scores order by sno desc");
			
			Score score=null;
			ArrayList<Score> scores = new ArrayList<Score>();
			while (rs.next()) {
				score = new Score();
				score.setNo(rs.getInt("sno"));
				score.setName(rs.getString("name"));
				score.setKor(rs.getInt("kor"));
				score.setEng(rs.getInt("eng"));
				score.setMath(rs.getInt("math"));
				scores.add(score);
			}
			return scores;
		} catch (Exception e) {
			throw e;
		} finally {
			try {	rs.close();	} catch (SQLException e) {	}
			try {	stmt.close();	} catch (SQLException e) {  }
			//try {	con.close(); } catch (SQLException e) {	}
			dbConnectionPool.returnConnection(con);
		}
	}

	public Score get(int no) throws Exception { 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		Score score;
		
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from scores where sno =" + no );
			
			if (rs.next()) {
				score = new Score();
				score.setNo(rs.getInt("sno"));
				score.setName(rs.getString("name"));
				score.setKor(rs.getInt("kor"));
				score.setEng(rs.getInt("eng"));
				score.setMath(rs.getInt("math"));
				return score;
				
			} else {
				return null;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {	rs.close();	} catch (SQLException e) {	}
			try {	stmt.close();	} catch (SQLException e) {  }
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public void setDbConnectionPool(DbConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}
	
	public void insert(Score score) throws Exception {
		Connection con = null;
		Statement stmt = null;// 로컬변수는 습관적으로 null로 세팅
		ResultSet rs = null; // 자동 생성된 pk 값(auto-increment value)을 가져오는 역할자
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.createStatement();

			int count = stmt
			    .executeUpdate("insert into scores (name, kor, eng, math)"
			        + " values ('" + score.getName() + "'," + score.getKor() + ","
			        + score.getEng() + "," + score.getMath() + ")",
			       Statement.RETURN_GENERATED_KEYS);
			
			if (count == 1) {
				// insert후 자동생성된 pk(sno)값 가져오기
				System.out.println("입력 완료!");
				rs = stmt.getGeneratedKeys(); //역할자 얻기
				rs.next(); //pk값 가져오기
				System.out.println(rs.getInt(1)); // 출력
				score.setNo( rs.getInt(1)); // select 해서 sno column을 가져온게 아니기때문에 column명을 적어서는안된다
			}

		} catch (Exception e) {
			throw e;
		} finally {			
			try {rs.close();} catch (SQLException e) {} 
			try {stmt.close();} catch (SQLException e) {}
			dbConnectionPool.returnConnection(con);
		}
	}

	public int delete(int no) throws Exception{
		Connection con = null;
		PreparedStatement stmt = null;// 로컬변수는 습관적으로 null로 세팅

		try {
			con = dbConnectionPool.getConnection();
			
			stmt = con.prepareStatement("delete from scores where sno = ?");
			stmt.setInt(1, no);
			
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {			
			try {stmt.close();} catch (SQLException e) {}
			dbConnectionPool.returnConnection(con);
		}
	}

	public int update(Score score) throws Exception{
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dbConnectionPool.getConnection();
			stmt = con.prepareStatement("update scores set name=?,kor=?,eng=?,math=? where sno=?");
			
			stmt.setString(1, score.getName());
			stmt.setInt(2, score.getKor());
			stmt.setInt(3, score.getEng());
			stmt.setInt(4, score.getMath());
			stmt.setInt(5, score.getNo());
			
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {			
			try {stmt.close();} catch (SQLException e) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
}
