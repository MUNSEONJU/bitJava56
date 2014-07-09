package report.report0707;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/report0707/member/delete")
public class MemberDelete extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	ServletContext ctx = this.getServletContext();
  	MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
  	
  	int no = Integer.parseInt(request.getParameter("no"));
  	PrintWriter out = response.getWriter();
  	try{
  		out.println("<!DOCTYPE html>");
 	    out.println("<html>");
 	    out.println("<head>");
 	    out.println("<meta charset=\"UTF-8\">");
 	    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
 	    out.println("<title>회원 삭제</title>");
 	    out.println("</head>");
 	    out.println("<body>");
 	    out.println("<p>삭제 성공</p>");
 	    out.println("</body>");
 	    out.println("</html>");
 	    memberDao.delete(no);
  	} catch (Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/report0707/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  		
  	
  }
  
}
