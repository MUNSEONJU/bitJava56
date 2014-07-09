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

@WebServlet("/report0707/member/add")
public class MemberAdd extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	PrintWriter out = response.getWriter();
  	
  	out.printf(" <!DOCTYPE html> ");
  	out.printf("   	<html> ");
  	out.printf(" <head> ");
  	out.printf(" <meta charset=\"UTF-8\"> ");
  	out.printf(" <title>Insert title here</title> ");
  	out.printf(" </head> ");
  	out.printf(" <body> ");
  	out.printf(" <h1>회원정보추가</h1> ");
  	out.printf(" <form action ='add' method = 'post'> ");
  	out.printf(" 이름 : <input type='text' name = 'name'><br/> ");
  	out.printf(" 메일 : <input type='text' name = 'email'><br/> ");
  	out.printf(" 전화 : <input type='text' name = 'tel'><br/> ");
  	out.printf(" 암호 : <input type='password' name = 'pwd'><br/> ");
  	out.printf(" <input type='submit' value='등록'> ");
  	out.printf(" </form> ");
  	out.printf(" </body> ");
  	out.printf(" </html> ");
  	
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	ServletContext ctx = this.getServletContext();
  	MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
  	
  	Member member = new Member();
  	
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
	    out.println("<title>회원 등록</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<p>등록 성공</p>");
	    out.println("</body>");
	    out.println("</html>");
	  	memberDao.insert(member);
  	} catch (Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/report0707/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  }
}
