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

@WebServlet("/score/step04/delete")
public class ScoreDelete extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  DbConnectionPool dbcp;
  ScoreDao scoreDao;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	int no = Integer.parseInt(request.getParameter("no"));
  	
  	try {
  		ServletContext ctx = this.getServletContext();
			ScoreDao scoreDao = (ScoreDao) ctx.getAttribute("scoreDao");
	    scoreDao.delete(no);
			response.setContentType("text/html; charset=UTF-8");
			response.sendRedirect("list");
			
    } catch (Exception e) {
    	RequestDispatcher rd = request.getRequestDispatcher("/score/step04/error");
			request.setAttribute("error", e);
			rd.forward(request, response);
    }
  }

}
