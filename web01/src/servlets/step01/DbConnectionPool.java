package servlets.step01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/** Connection Pool **/
//	- DB Connection 객체를 빌려주고 반납받는 역할 수행
//	- 객체를 빌려주고 반납받는 방식의 프로그래밍을 "Pooling 기법"이라고 한다.
//	- 디자인패턴에서는 "Flyweight 패턴"이라고 한다.

public class DbConnectionPool {
	ArrayList<Connection>	connections = new ArrayList<Connection>();
	String driver;
	String url;
	String username;
	String password;
	public DbConnectionPool(String driver, String url, 
			String username, String password) throws ClassNotFoundException{
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
		
		Class.forName(driver);
	}
	
	public Connection getConnection() throws SQLException{
		if(connections.size()==0){
			return DriverManager.getConnection(this.url,this.username,this.password);
		} else {
			return connections.remove(0); //0번값을 꺼내줌과 동시에 ArrayList에서는 제거된다.
		}
	}
	
	public void returnConnection(Connection con){
		try{
			if( !con.isClosed() && con.isValid(1) ){
				connections.add(con);
			}
		} catch(SQLException e) { /* 무시 */ }
	}

	public void closeAll() {
		for (Connection con : connections) {
      try {
        if (con.isValid(1) && !con.isClosed()) {
          con.close();
        }
      } catch (Exception e) {}
    }
  }
	
}
