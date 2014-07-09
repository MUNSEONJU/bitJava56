package servlets.step04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step04/add")
public class ScoreAdd extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		Score score= new Score();
		
			score.setName(request.getParameter("name"));
			score.setKor(Integer.parseInt(request.getParameter("kor")));
			score.setEng(Integer.parseInt(request.getParameter("eng")));
			score.setMath(Integer.parseInt(request.getParameter("math")));
			
			//ServletContext에서 꺼내쓰기에 init ( dbcp 등 ),destroy 필요없음
			ServletContext ctx = this.getServletContext();
			ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
			
		try{
			scoreDao.insert(score);
			response.setContentType("text/html; charset=UTF-8");
			response.sendRedirect("list");
			
		} catch (Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("/score/step04/error");
			request.setAttribute("error", e);
			rd.forward(request, response);
		}
		
	}
	
}
