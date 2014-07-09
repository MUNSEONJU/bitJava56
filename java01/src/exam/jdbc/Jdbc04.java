package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// UPDATE

public class Jdbc04 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); // 예외처리
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bitdb","bit","1111");
		Statement stmt = con.createStatement();
		
		//executeUpdate() : INSERT, UPDATE, DELETE 문 수행
		//	- 리턴값은 생성되거나, 변경되거나, 삭제된 레코드의 갯수(integer)
		
		int count = stmt.executeUpdate( // 실제 삭제된 record숫자
				"delete from members where mno=14"
				);
				
		if(count == 1){ // 1column return
			System.out.println("삭제 완료"); // 조건에 해당하는 column이 없으면 삭제불가 , 0 return
		}
		
		stmt.close();
		con.close();
	}

}
