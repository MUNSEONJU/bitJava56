package exam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// 역할자 = 클래스
//	- 어떤 기능을 수행하는 클래스를 지칭
//	- 기능 = 메서드
//	- 메서드는 인스턴스를 통해 호출한다.
//		-> 역할자를 "객체"라 칭한다.

public class Jdbc01 {

	public static void main(String[] args) throws Exception {
		// JDBC 사용절차
		// 1. Driver 역할자(객체)를 로딩한다.
		//	- Driver 역할자?
		//		: JDBC 드라이버의 정보를 알려주는 객체
		//		: DBMS와의 연결을 수행하는 객체
		//		: java.sql.Driver 인터페이스를 구현한 객체
		//	- Driver 역할자 로딩?
		//		: java.sql.Driver 구현체(구현한 클래스)를 로딩한다.
		//		: ex) MySQL JDBC Driver -> com.mysql.jdbc.Driver 클래스
		//	- 임의로 Class 로딩방법?
		//		: java.lang.Class.forName("클래스이름")
		//		: 클래스 이름은 반드시 패키지 이름을 포함하여 입력
		//	- 클래스로딩
		Class.forName("com.mysql.jdbc.Driver"); // 예외처리
		
		// 2. DriverManager를 통해 Connection 역할자를 얻기
		//	- 동작 원리
		//		: DriverManager의 getConnection()호출
		//		: DriverManager는 Loading된 com.mysql.jdbc.Driver인스턴스를 생성한 후
			/** 클래스로딩 절차를 거치지 않고 Driver 인스턴스를 직접 생성하는 경우도 있음 **/
		//		: com.mysql.jdbc.Driver 객체의 connect()함수를 호출한다.
		//		: com.mysql.jdbc.Driver는 MySQL DBMS와의 연결을 관리하는 
		//			Connection객체를 생성한 후 return 한다.
		//		: DriverManager는 com.mysql.jdbc.Driver의 connect()가 리턴한 값을 다시 리턴한다.
		//		: Connection(java.sql) 객체
		//			- DBMS 인증정보를 갖고 있다. (SQL 질의 입력시 사용
		//			- DBMS와의 연결을 관리한다.
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/bitdb", 		
				// DBMS에 접속하는 JDBC URL 주소, DBMS마다 url 규칙이 조금씩 다르다. 매뉴얼참조
				"bit",  		// DBMS 접속할 때 사용하는 사용자 ID
				"1111"	);	// DBMS 접속할 때 사용하는 사용자 PASSWORD
		
		// 3. Connection 역할자를 통해 Statement 역할자를 얻기
		//	- Statement(java.sql) 객체
		//		: DBMS에 SQL을 전달하는 역할을 수행한다.
		Statement stmt = con.createStatement();
		
		// 4. statement 역할자를 통해 SQL을 서버에 보낸다
		//	- select -> executeQuery("SQL문");, 또는 execute() 호출
		//	- INSERT, UPDATE, DELETE -> executeUpdate("Query문"), 또는 execute()호출
		//	- 전자 추천
		//	- executeQuery()메서드
		//		: 서버로부터 결과 레코드를 가져오는 작업을 수행할 ResultSet(java.sql) 객체 리턴
		
		ResultSet rs = stmt.executeQuery("select mno,name,email,tel from members");
		
		// 5. ResultSet 역할자를 통해 서버에서 레코드를 하나씩 가져온다.
		//	- ResultSet의 next()메서드
		//		: 서버로부터 레코드를 1개 가져오는 역할
		//		: 구현체에 따라 미리 약간의 레코드를 서버에서 가져올 수 있음 (cache)
		//		: 레코드를 가져왔으면 true, 가져오지 못했으면(없으면) false 리턴
		//		: 가져온 레코드값은 자신이 가지고 있다.
		//	- GetXXX() 메서드
		//		: 서버에서 가져온 레코드로부터 컬럼값을 꺼내는 메서드
		//		: 컬럼의 타입에 따라 적당한 메서드를 호출해야한다
		//		: ex) 문자 : getString(), 숫자 getInt(), 날짜 getDate()
		//		: 파라미터 값으로 컬럼의 인덱스(1부터시작)나 이름을 주면 된다.
		//		: [권고]SQL문의 영향을 덜 받으려면 파라미터 값으로 컬럼의 이름을 사용할것.length
		//		: ex) rs.getInt(1) 하면 MNO 호출 가능하지만, 파라미터 추가하면 인덱스가 바뀔수있으니..
		while(rs.next()){
			System.out.print(rs.getInt("mno")+"/");
			System.out.print(rs.getString("name")+"/");
			System.out.print(rs.getString("email")+"/");
			System.out.println(rs.getString("tel"));
		}
		
		/*** 객체를 닫을때(연결을 끊을때)는 항상 거꾸로 수행한다.***/
		
		// 6. ResultSet 역할자를 더이상 사용하지 않으면 연결끊기
		rs.close();
		
		// 7. Statement 역할자 끊기
		stmt.close();
		
		// 8. Connection 역할자 끊기
		//	- DBMS에 연결하고 작업을 수행했으면 연결을 끊어줘야 한다.
		//		: 그래야 다른 어플리케이션에서 사용할 수 있다
		//	- close()메서드를 수행하지 않는다면?
		//		: DBMS는 내부적으로 설정된 시간(timeout) 동안에는 계속 해당연결을 유지한다.
		//		: timeout되면 그제서야 서버쪽에서의 연결을 끊는다.
		con.close();
	}

}
