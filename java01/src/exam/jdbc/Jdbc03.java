package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// UPDATE

public class Jdbc03 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); // 예외처리
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bitdb","bit","1111");
		Statement stmt = con.createStatement();
		
		//executeUpdate() : INSERT, UPDATE, DELETE 문 수행
		//	- 리턴값은 생성되거나, 변경되거나, 삭제된 레코드의 갯수(integer)
		
		int count = stmt.executeUpdate( // 실제 변경된 record숫자
				"update members set tel='010-1111-1234' where mno=14"
				);
				
		if(count == 1){ // 1column return
			System.out.println("변경 완료"); // where절 조건에 해당하는 값이 없으면 0 return
		}
		
		stmt.close();
		con.close();
	}

}
