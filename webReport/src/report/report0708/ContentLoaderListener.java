package report.report0708;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContentLoaderListener implements ServletContextListener {
	
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
	  	MemberDao dao = new MemberDao();
	  	dao.setDbConnectionPool(dbcp);
	  	
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
