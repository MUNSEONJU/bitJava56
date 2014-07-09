package report.report0707;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContentLoaderListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
	    DbConnectionPool dbcp = new DbConnectionPool("com.mysql.jdbc.Driver",
	    		"jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
	        "bit", "1111");
	  	MemberDao dao = new MemberDao();
	  	dao.setDbConnectionPool(dbcp);
	  	
	  	ServletContext ctx = event.getServletContext();
	  	ctx.setAttribute("dbConnectionPool", dbcp);
	  	ctx.setAttribute("memberDao", dao);
	  	
    } catch (Exception e) {
	    e.printStackTrace();
    }	
	}

	@Override
  public void contextDestroyed(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();
	  DbConnectionPool dbcp = (DbConnectionPool) ctx.getAttribute("dbConnectionPool");
	  dbcp.closeAll();	
  }

}
