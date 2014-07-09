package report.report0708;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/report0708/list")
public class MemberList extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
  		throws ServletException ,IOException {
  	PrintWriter out = response.getWriter();
  	ServletContext ctx = this.getServletContext();
  	MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");

  	try{
			ArrayList<Member> members = memberDao.load();	

			RequestDispatcher rd = request.getRequestDispatcher("/member/report0708/MemberList.jsp");
			request.setAttribute("members", members);
			rd.include(request,response);
			
		} catch (Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("/member/report0708/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
		}
		
		
		out.printf("   </table> ");
		out.printf(" </body> ");
		out.printf(" </html> ");
  }
}
