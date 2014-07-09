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

@WebServlet("/report0707/member/update")
public class MemberUpdate extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	ServletContext ctx = this.getServletContext();
  	MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
  	PrintWriter out = response.getWriter();
  	int no = Integer.parseInt(	request.getParameter("no") );
  	try{
	  	Member member = memberDao.get(no);	  	
	  	String name = member.getName();
	  	String email = member.getEmail();
	  	String tel = member.getTel();
	  	//String pwd = member.getPwd();
	  	
	  	out.printf(" <!DOCTYPE html> ");
	  	out.printf("   	<html> ");
	  	out.printf(" <head> ");
	  	out.printf(" <meta charset=\"UTF-8\"> ");
	  	out.printf(" <title>회원정보변경</title> ");
	  	out.printf(" </head> ");
	  	out.printf(" <body> ");
	  	out.printf(" <h1>회원정보변경</h1> ");
	  	out.printf(" <form action ='update' method = 'post'> ");
	  	out.printf(" 번호 : <input type='text' name = 'mno' value = '%1$s' readonly><br/>"
	  			, request.getParameterValues("no"));
	  	out.printf(" 이름 : <input type='text' name = 'name' value = '%1$s'><br/> ",name);
	  	out.printf(" 메일 : <input type='text' name = 'email' value = '%1$s'><br/> ",email);
	  	out.printf(" 전화 : <input type='text' name = 'tel' value = '%1$s'><br/> ",tel);
	  	out.printf(" 암호 : <input type='password' name = 'pwd'><br/> ");
	  	out.printf(" <input type='submit' value='변경'> ");
	  	out.printf(" </form> ");
	  	out.printf(" </body> ");
	  	out.printf(" </html> ");
  	}  catch (Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/report0707/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	ServletContext ctx = this.getServletContext();
  	MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
  	
  	Member member = new Member();
  	
  	member.setMno(Integer.parseInt(request.getParameter("mno")));
  	member.setName(request.getParameter("name"));
  	member.setEmail(request.getParameter("email"));
  	member.setTel(request.getParameter("tel"));
  	member.setPwd(request.getParameter("pwd"));

  	PrintWriter out = response.getWriter();
  	try{
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<meta charset=\"UTF-8\">");
	    out.println("<meta http-equiv='Refresh' content='1; url=list'>");
	    out.println("<title>회원 정보 변경</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<p>변경 성공</p>");
	    out.println("</body>");
	    out.println("</html>");
	  	memberDao.update(member);
  	} catch (Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/report0707/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  }
}
