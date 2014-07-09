/* 배열 대신 ArrayList 적용 
 */
package exam.jdbc.step01_report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ScoreDao {

  public ScoreDao() {
  	
  }

  public void insert(Score score) {
  	try{
			Class.forName("com.mysql.jdbc.Driver"); // 예외처리
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bitdb","bit","1111");
			Statement stmt = con.createStatement();
			
			int count = stmt.executeUpdate(
					" insert into scores(NAME,KOR,ENG,MATH)" 
					+ " values ('" + score.getName() + "'," 
					+ score.getKor()+"," 
					+ score.getEng()+ ","
					+ score.getMath()+")" 
					);
					
			if(count == 1){ 
				System.out.println("입력 완료"); 
				new ScoreFrame();
			}
			
			stmt.close();
			con.close();
  	} catch (Exception e){
  		e.printStackTrace(); // 대체 어떤 예외인지 상세하게 알고 싶어서
  	}
  }
  

  public Score nextScore() {
  	try{
	  	Class.forName("com.mysql.jdbc.Driver");
	  	Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bitdb","bit","1111");
			Statement stmt = con.createStatement();
			
				if(ScoreFrame.currSno < ScoreFrame.count){
					ResultSet rs = stmt.executeQuery(
					"select name,kor,eng,math from scores"
					+ " where sno =" + ScoreFrame.sno[ScoreFrame.currSno+1]);
					rs.next();
					Score score = new Score();
					score.setName(rs.getString("name"));
					score.setKor(rs.getInt("kor"));
					score.setEng(rs.getInt("eng"));
					score.setMath(rs.getInt("math"));
					rs.close();
					stmt.close();
					con.close();
					ScoreFrame.currSno++;
					return score;
				}	
				else {
					return null;
				}
				
			
			
			
  	} catch(Exception e){
  		e.printStackTrace();
  		return null;
  	}
  }

  public Score previousScore() {
  	try{
	  	Class.forName("com.mysql.jdbc.Driver");
	  	Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bitdb","bit","1111");
			Statement stmt = con.createStatement();

			
				
				if(ScoreFrame.currSno <= 1){
					return null;
				} else {
				ScoreFrame.currSno--;
				ResultSet rs = stmt.executeQuery(
					"select name,kor,eng,math from scores"
					+ " where sno =" + ScoreFrame.sno[ScoreFrame.currSno]);
					rs.next();
					Score score = new Score();
					score.setName(rs.getString("name"));
					score.setKor(rs.getInt("kor"));
					score.setEng(rs.getInt("eng"));
					score.setMath(rs.getInt("math"));
					rs.close();
					stmt.close();
					con.close();
					return score;
				}
  	} catch(Exception e){
  		e.printStackTrace();
  		return null;
  	}
  }
}










