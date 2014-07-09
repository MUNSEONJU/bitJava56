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

@WebServlet("/member/report0708/update")
public class MemberUpdate extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	try{
  		ServletContext ctx = this.getServletContext();
  		MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
  		int mno = Integer.parseInt(	request.getParameter("mno") );
  		
	  	Member member = memberDao.get(mno);	  	

	  	RequestDispatcher rd = request.getRequestDispatcher(
	  			"/member/report0708/MemberUpdate.jsp");
	  	request.setAttribute("member", member);
	  	rd.include(request, response);
	  			
	  			
  	}  catch (Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/report0708/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	try{
	  	ServletContext ctx = request.getServletContext();
	  	MemberDao dao = (MemberDao) ctx.getAttribute("memberDao");
	  	Member member = new Member();
	  	
	  	int mno = Integer.parseInt(request.getParameter("mno"));
	  	member.setMno(mno);
	  	member.setName(request.getParameter("name"));
	  	member.setEmail(request.getParameter("email"));
	  	member.setTel(request.getParameter("tel"));
	  	member.setPwd(request.getParameter("pwd"));
	  	
	  	dao.update(member);
	  	response.sendRedirect("list");
	  	
  	} catch(Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/report0708/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  	
  	
  }
  
  
}
