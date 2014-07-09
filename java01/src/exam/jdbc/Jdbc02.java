package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// INSERT

public class Jdbc02 {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver"); // 예외처리
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bitdb","bit","1111");
		Statement stmt = con.createStatement();
		
		//executeUpdate() : INSERT, UPDATE, DELETE 문 수행
		//	- 리턴값은 생성되거나, 변경되거나, 삭제된 레코드의 갯수(integer)
		
		int count = stmt.executeUpdate(
				"insert into members(name,email,tel,pwd) " // pwd) values 사이에 공백 주의!
				+ " values ('윤봉길','s11@test.com','111-1010','1111')" // value앞에 공백을 주면 안잊어먹어
				);
				
		if(count == 1){ // 1column return
			System.out.println("입력 완료"); // 식별자(중복)로인해 insert 불가능할 경우 0 return
		}
		
		stmt.close();
		con.close();
	}

}
