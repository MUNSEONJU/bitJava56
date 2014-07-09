package report.report0708;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/report0708/delete")
public class MemberDelete extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	ServletContext ctx = this.getServletContext();
  	MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
  	try{
  		int mno = Integer.parseInt(request.getParameter("mno"));
 	    memberDao.delete(mno);
 	    response.sendRedirect("list");
  	} catch (Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/member/report0708/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  		
  	
  }
  
}
