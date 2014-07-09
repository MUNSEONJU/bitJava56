package servlets.step03;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;


/** Web App이 시작 될 때  자동 생성되는 서블릿 (초기화) **/
//	- 보통 서블릿은 클라이언트에서 최초로 요청할 때 생성된다.
//	- 그러나 web.xml에 설정을 하면 클라이언트가 요청하지 않아도 자동 생성된다.
//	- <servlet>
//		..
//		<load-on-startup> 실행순서 </load-on-startup>
//		</servlet>
//	- 클라이언트 요청을 처리하는 용도가 아니기 때문에 URL 매핑은 하지 말라

public class ContextLoaderServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  
	@Override
	public void init(ServletConfig config) throws ServletException {
	  super.init(config);
	  try {
	    DbConnectionPool dbcp = new DbConnectionPool(
	    		config.getInitParameter("driver"),
	    		config.getInitParameter("url"),
	    		config.getInitParameter("username"),
	    		config.getInitParameter("password"));
	  	ScoreDao scoreDao = new ScoreDao();
	  	scoreDao.setDbConnectionPool(dbcp);
	  	
	  	ServletContext ctx = this.getServletContext();
	  	ctx.setAttribute("dbConnectionPool", dbcp);
	  	ctx.setAttribute("scoreDao", scoreDao);
    } catch (Exception e) {
	    e.printStackTrace();
    }
  }

	
	@Override
	public void destroy() {
	  super.destroy();
	  ServletContext ctx = this.getServletContext();
	  DbConnectionPool dbcp = (DbConnectionPool) ctx.getAttribute("dbConnectionPool");
	  dbcp.closeAll();
	}
}
