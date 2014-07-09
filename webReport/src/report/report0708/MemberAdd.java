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

@WebServlet("/member/report0708/add")
public class MemberAdd extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	try{
	  	ServletContext ctx = request.getServletContext();
	  	MemberDao dao = (MemberDao)ctx.getAttribute("memberDao");
	  	Member member = new Member();
	  	
	  	String name = request.getParameter("name");
	  	String email = request.getParameter("email");
	  	String tel = request.getParameter("tel");
	  	String pwd = request.getParameter("pwd");
	  	
	  	member.setName(name);
	  	member.setEmail(email);
	  	member.setTel(tel);
	  	member.setPwd(pwd);
	  	
	  	dao.insert(member);
	  	
	  	response.sendRedirect("list");
  	} catch (Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/member/report0708/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  	
  }
}
