package servlets.step02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step02/add")
public class ScoreAdd extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		Score score= new Score();
		try{
			score.setName(request.getParameter("name"));
			score.setKor(Integer.parseInt(request.getParameter("kor")));
			score.setEng(Integer.parseInt(request.getParameter("eng")));
			score.setMath(Integer.parseInt(request.getParameter("math")));
			
			//ServletContext에서 꺼내쓰기에 init ( dbcp 등 ),destroy 필요없음
			ServletContext ctx = this.getServletContext();
			ScoreDao scoreDao = (ScoreDao) ctx.getAttribute("scoreDao");
			scoreDao.insert(score);
		
		} catch (Exception e){
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=UTF-8");
			
		PrintWriter out = response.getWriter();
			
		out.println(" <!DOCTYPE html>");
		out.println(" <html>");
		out.println(" <head>");
		out.println(" <meta charset='UTF-8'>");
		out.println(" <meta http-equiv='Refresh' content='1; url=list'>");
		out.println(" <title>등록 성공</title>");
		out.println(" </head>");
		out.println(" <body>");
		out.println(" <p> 등록되었습니다. </p>");
		out.println(" </body>");
		out.println(" </html>");
		
	}
	
}
