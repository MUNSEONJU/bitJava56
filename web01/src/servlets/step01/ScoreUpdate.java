package servlets.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/score/update")
public class ScoreUpdate extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  DbConnectionPool dbcp;
  ScoreDao scoreDao;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
  	super.init(config); // overriding하기 전의 init
  	
  	try {
	    dbcp = new DbConnectionPool("com.mysql.jdbc.Driver",
	    		"jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
	        "bit", "1111");
    } catch (Exception e) {
	    e.printStackTrace();
    }
  	scoreDao = new ScoreDao();
  	scoreDao.setDbConnectionPool(dbcp);
  }
  
  @Override
  public void destroy() {
    super.destroy();
    dbcp.closeAll();
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	String name = request.getParameter("name");
  	int kor = Integer.parseInt(request.getParameter("kor"));
  	int eng = Integer.parseInt(request.getParameter("eng"));
  	int math = Integer.parseInt(request.getParameter("math"));
  	int no = Integer.parseInt(request.getParameter("no"));
  	Score score = new Score();
  	score.setName(name);
  	score.setKor(kor);
  	score.setEng(eng);
  	score.setMath(math);
  	score.setNo(no);
  	try {
	    scoreDao.update(score);
			response.setContentType("text/html; charset=UTF-8");
				
			PrintWriter out = response.getWriter();
				
			out.println(" <!DOCTYPE html>");
			out.println(" <html>");
			out.println(" <head>");
			out.println(" <meta charset='UTF-8'>");
			out.println(" <meta http-equiv='Refresh' content='1; list'>");
			out.println(" <title>성적 변경</title>");
			out.println(" </head>");
			out.println(" <body>");
			out.println(" <p> 변경 되었습니다. </p>");
			out.println(" </body>");
			out.println(" </html>");
			
    } catch (Exception e) {
    	e.printStackTrace();
    }
  }
  
}
