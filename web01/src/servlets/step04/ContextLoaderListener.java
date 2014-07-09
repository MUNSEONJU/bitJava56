package servlets.step04;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/** ServletContextListener **/
//	- ServletContextEvent 
//		: 웹 어플리케이션을 시작하거나 종료할 때 발생되는 이벤트
//	- ServletContextEvent를 처리하는 역할
//	- WebApp 시작할때 초기작업 / WebApp 종료할 때 마무리 작업 수행


public class ContextLoaderListener implements ServletContextListener {

	
	//웹 어플리케이션이 실행될 때 호출된다.
	// -> WebApp을 위한 공용 자원을 준비한다.
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			ServletContext ctx = event.getServletContext();
	    DbConnectionPool dbcp = new DbConnectionPool(
	    		ctx.getInitParameter("driver"),
	    		ctx.getInitParameter("url"),
	    		ctx.getInitParameter("username"),
	    		ctx.getInitParameter("password")
	    		);
	  	ScoreDao scoreDao = new ScoreDao();
	  	scoreDao.setDbConnectionPool(dbcp);
	  	
	  	ctx.setAttribute("dbConnectionPool", dbcp);
	  	ctx.setAttribute("scoreDao", scoreDao);
	  	
    } catch (Exception e) {
	    e.printStackTrace();
    }	
	}
	
	//웹 어플리케이션이 종료될 때 호출된다.
	// -> WebApp을 위한 공용 자원을 해제한다.
	@Override
  public void contextDestroyed(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
	  DbConnectionPool dbcp = (DbConnectionPool) ctx.getAttribute("dbConnectionPool");
	  dbcp.closeAll();	  
  }

	
	
}
