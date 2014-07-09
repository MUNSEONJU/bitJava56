		/** PreparedStatement 적용 **/
//	- sql 템플릿을 정의한 후 IN - PARAMETER에 값을 넣는 방법
//	- 장점
//		1) 간결해지는 SQL문
//	☆  2) IN - PARAMETER를 통해 값을 입력하기 때문에 sql문을 조작할 수 없다.(보안)
//	☆  3) binary data를 입력할 수 있다.
//		4) 반복적으로 작업을 수행할 때 속도가 빠르다.
//			( sql문을 미리 만들어 놓고 값만 입력하여 실행하기 때문이다 ) 

package exam.jdbc.step04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDao {
	DbConnectionPool dbConnectionPool;
	Score currScore;
	
	public void prepare() { 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; 

		try {
			con = dbConnectionPool.getConnection();
			
			stmt = con.createStatement();

			rs = stmt.executeQuery("select sno, name, kor, eng, math "
			    + " from scores order by sno desc limit 1");

			if (rs.next()) {
				currScore = new Score();
				currScore.setNo(rs.getInt("sno"));
				currScore.setName(rs.getString("name"));
				currScore.setKor(rs.getInt("kor"));
				currScore.setEng(rs.getInt("eng"));
				currScore.setMath(rs.getInt("math"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {	rs.close();	} catch (SQLException e) {	}
			try {	stmt.close();	} catch (SQLException e) {  }
			//try {	con.close(); } catch (SQLException e) {	}
			dbConnectionPool.returnConnection(con);
		}
	}

	public void setDbConnectionPool(DbConnectionPool dbConnectionPool) {
		this.dbConnectionPool = dbConnectionPool;
	}
	
	public void insert(Score score) {
		Connection con = null;
		PreparedStatement stmt = null; // 준비된(prepared) 문장(Statement)
		ResultSet rs = null; // 자동 생성된 pk 값(auto-increment value)을 가져오는 역할자
		try {
			con = dbConnectionPool.getConnection();
			
			con.prepareStatement("insert into scores (name, kor, eng, math) "
					+ " values(?,?,?,?)" 
					, Statement.RETURN_GENERATED_KEYS); // ? : IN - PARAMETER
			
			// IN-PARAMETER의 타입에 따라 set???(index, value) 호출
			stmt.setString(1, score.getName());
			stmt.setInt(2, score.getKor());
			stmt.setInt(3, score.getEng());
			stmt.setInt(4, score.getMath());
			
			int count = stmt.executeUpdate();
			
			if (count == 1) {
				System.out.println("입력 완료!");
				rs = stmt.getGeneratedKeys();
				rs.next(); 
				score.setNo( rs.getInt(1));
				currScore = score;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			try {rs.close();} catch (SQLException e) {} 
			try {stmt.close();} catch (SQLException e) {}
			//try {con.close();} catch (SQLException e) {}
			dbConnectionPool.returnConnection(con);
		}
	}

	public Score next() {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; // 로컬변수는 습관적으로 null로 세팅

		try {
			con = dbConnectionPool.getConnection();
			stmt= con.prepareStatement("select sno,name,kor,eng,math"
					+ " from scores"
					+ " where sno > ?");
			
			stmt.setInt(1, currScore.getNo());
			// where 절에 서브 쿼리 적용
			rs = stmt.executeQuery();
			
			if (rs.next()) {
				currScore = new Score();
				currScore.setNo(rs.getInt("sno"));
				currScore.setName(rs.getString("name"));
				currScore.setKor(rs.getInt("kor"));
				currScore.setEng(rs.getInt("eng"));
				currScore.setMath(rs.getInt("math"));
				return currScore;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {			
			try {rs.close();} catch (SQLException e) {}
			try {stmt.close();} catch (SQLException e) {}
			//try {con.close();} catch (SQLException e) {}
			dbConnectionPool.returnConnection(con);
		}
	}

	public Score previous() {
		/*
		if(currScore == null){
			return null;
		}
		*/
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; // 로컬변수는 습관적으로 null로 세팅

		try {
			con = dbConnectionPool.getConnection();
			stmt= con.prepareStatement("select sno,name,kor,eng,math"
					+ " from scores"
					+ " where sno < ?");
			
			stmt.setInt(1, currScore.getNo());
			
			rs = stmt.executeQuery();

			if (rs.next()) {
				currScore = new Score();
				currScore.setNo(rs.getInt("sno"));
				currScore.setName(rs.getString("name"));
				currScore.setKor(rs.getInt("kor"));
				currScore.setEng(rs.getInt("eng"));
				currScore.setMath(rs.getInt("math"));
				return currScore;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {			
			try {rs.close();} catch (SQLException e) {}
			try {stmt.close();} catch (SQLException e) {}
			//try {con.close();} catch (SQLException e) {}
			dbConnectionPool.returnConnection(con);
		}
		
	}

	public void delete() {
		Connection con = null;
		PreparedStatement stmt = null;// 로컬변수는 습관적으로 null로 세팅

		try {
			con = con = dbConnectionPool.getConnection();
			stmt= con.prepareStatement("delete from scores"
	        + " where sno = ?");
			
			stmt.setInt(1, currScore.getNo());
			
			int count = stmt.executeUpdate();
			

			if (count == 1) {
				System.out.println("삭제 완료!");
				// 삭제했으면 이전점수를 가져와야한다
				Score score = previous();
				if(score == null){
					score = next();
					currScore = null;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			try {stmt.close();} catch (SQLException e) {}
			//try {con.close();} catch (SQLException e) {}
			dbConnectionPool.returnConnection(con);
		}
	}

	public void update() {
		Connection con = null;
		PreparedStatement stmt = null;// 로컬변수는 습관적으로 null로 세팅
		ResultSet rs = null; // 자동 생성된 pk 값(auto-increment value)을 가져오는 역할자
		try {
			con = dbConnectionPool.getConnection();
			stmt= con.prepareStatement("update scores set "
	    		+ " name = ?, kor =  ?, eng = ?, math = ? "
	    		+ " where sno = ?)");
			stmt.setString(1, currScore.getName());
			stmt.setInt(2, currScore.getKor());
			stmt.setInt(3, currScore.getEng());
			stmt.setInt(4, currScore.getMath());
			stmt.setInt(5, currScore.getNo());
			int count = stmt.executeUpdate();
			if (count == 1) {
				// insert후 자동생성된 pk(sno)값 가져오기
				System.out.println("변경성공!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			try {rs.close();} catch (SQLException e) {} 
			try {stmt.close();} catch (SQLException e) {}
			//try {con.close();} catch (SQLException e) {}
			dbConnectionPool.returnConnection(con);
		}
	}
	
	public Score getCurrentScore() {
		return currScore;
	}

}
