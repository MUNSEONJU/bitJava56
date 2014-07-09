package servlets.step01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/score/updateform")
public class UpdateForm extends HttpServlet {
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
  	int no = Integer.parseInt(request.getParameter("no"));
  	
  	Score score = new Score();
  	try {
  		
  		score = scoreDao.get(no);
  		String name = score.getName();
  		int kor = score.getKor();
  		int eng = score.getEng();
  		int math = score.getMath();
  		response.setContentType("text/html; charset=UTF-8");
				
			PrintWriter out = response.getWriter();
				
			out.println(" <!DOCTYPE html>");
			out.println(" <html>");
			out.println(" <head>");
			out.println(" <meta charset='UTF-8'>");
			out.println(" <title>성적 수정</title>");
			out.println(" </head>");
			out.println(" <body>");
			out.println(" <h1>성적수정</h1>");			
			out.format(" <form action='update?name=name&kor=kor&eng=eng&math=math&sno=no' method='get'>");
			out.format(" <p>이름 : <input type='text' name='name' value='%1$s'></p>",name);
			out.format(" <p>국어 : <input type='text' name='kor' value='%1$d'></p>",kor);
			out.format(" <p>영어 : <input type='text' name='eng' value='%1$d'></p>",eng);
			out.format(" <p>수학 : <input type='text' name='math'value='%1$d'></p>",math);		
			out.format(" <input type = 'hidden' name='no' value='%1$d'> ",no);
			out.println(" <input type='submit' value='수정'>");			
			out.println(" </form>");
			out.println(" </body>");
			out.println(" </html>");
			
    } catch (Exception e) {
    	e.printStackTrace();
    }
  }
  
}
