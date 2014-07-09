// close() 정석
//	- 오류가 발생했을 때도  정상적으로 연결을 끊을 수 있도록 처리한다.
//	- try.. catch.. finally

// Auto-Generated Key Value 가져오기
//	- excute??(sql, Statement.RETURN_GENERATED_KEYS);
//	- getGeneratedKeys()
package exam.jdbc.step02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScoreDao {
	Score currScore;

	public ScoreDao() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; // 로컬변수는 습관적으로 null로 세팅

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
			    .getConnection(
			        "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
			        "bit", "1111");
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
		} finally { // 정상이든 예외상황이든 무조건 수행해야하는 블록
			          // 즉, try블럭이나 catch블럭 나가기 전에 반드시 수행해야하는 작업
			          // try나 catch에 return문을 만나도 "반드시!" finally 문 수행하고 빠져나간다.
			try {
				rs.close();
			} catch (SQLException e) {
			}
			try {
				stmt.close();
			} catch (SQLException e) {
			}
			try {
				con.close();
			} catch (SQLException e) {
			}
			// close() 는 절대 집단으로 예외처리해서는 안된다.
			// 만일 본문에서 rs에 대입하는 SQL문에 오류가난다면 rs는 값을 반환받지못한채 null로 catch로온다
			// rs.close()메서드 호출할수 없으므로 나머지 stmt,con close하지 않고 빠져나감..
			// 따라서 따로따로

		}
	}

	public void insert(Score score) {
		Connection con = null;
		Statement stmt = null;// 로컬변수는 습관적으로 null로 세팅
		ResultSet rs = null; // 자동 생성된 pk 값(auto-increment value)을 가져오는 역할자
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
			    .getConnection(
			        "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
			        "bit", "1111");
			stmt = con.createStatement();

			int count = stmt
			    .executeUpdate("insert into scores (name, kor, eng, math)"
			        + " values ('" + score.getName() + "'," + score.getKor() + ","
			        + score.getEng() + "," + score.getMath() + ")",
			       Statement.RETURN_GENERATED_KEYS);
				// execyteUpdate("SQL",Statement.RETURN_GENERATED_KEYS);
				// 해서 generatedkey를 얻고
			
			if (count == 1) {
				// insert후 자동생성된 pk(sno)값 가져오기
				System.out.println("입력 완료!");
				rs = stmt.getGeneratedKeys(); //역할자 얻기
				rs.next(); //pk값 가져오기
				//System.out.println(rs.getInt(1)); // 출력
				score.setNo( rs.getInt(1));
				currScore = score;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {			
			try {rs.close();} catch (SQLException e) {} 
			try {stmt.close();} catch (SQLException e) {}
			try {con.close();} catch (SQLException e) {}
		}
	}

	public Score next() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; // 로컬변수는 습관적으로 null로 세팅

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
			    .getConnection(
			        "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
			        "bit", "1111");
			stmt = con.createStatement();

			// where 절에 서브 쿼리 적용
			rs = stmt.executeQuery("select sno, name, kor, eng, math"
			    + " from scores "
			    + " where sno = ( select min(sno) from scores where sno > "
			    + currScore.getNo() + " )");

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
			try {con.close();} catch (SQLException e) {}
		}
	}

	public Score previous() {
		/*
		if(currScore == null){
			return null;
		}
		*/
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null; // 로컬변수는 습관적으로 null로 세팅

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
			    .getConnection(
			        "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
			        "bit", "1111");
			stmt = con.createStatement();

			// where 절에 서브 쿼리 적용
			rs = stmt.executeQuery("select sno, name, kor, eng, math"
			    + " from scores "
			    + " where sno = ( select max(sno) from scores where sno < "
			    + currScore.getNo() + " )");

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
			try {con.close();} catch (SQLException e) {}
		}
		
	}

	public void delete() {
		Connection con = null;
		Statement stmt = null;// 로컬변수는 습관적으로 null로 세팅

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager
			    .getConnection(
			        "jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
			        "bit", "1111");
			stmt = con.createStatement();
			
			int count = stmt
			    .executeUpdate("delete from scores"
			        + " where sno = " + currScore.getNo());
			

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
			try {con.close();} catch (SQLException e) {}
		}
	}

	public Score getCurrentScore() {
		return currScore;
	}
}
