package report.report0707;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/report0707/member/askPassword")
public class AskPassWord extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	String insertedPW = request.getParameter("password"); // 확인하려는 비번
  	String destination = request.getParameter("destination");
  	int mno = Integer.parseInt(request.getParameter("mno"));
  	
  	ServletContext ctx = this.getServletContext();
  	MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
  	
  	try{
  		Member member = memberDao.get(mno);
  		String correctPW = member.getPwd();
  		if( correctPW.equals(insertedPW) ){
  			response.sendRedirect(destination);
  		} else{
  			PrintWriter out = response.getWriter();
  			out.println(" <!DOCTYPE html> ");
  	  	out.println(" <html> ");
  	  	out.println(" <head> ");
  	  	out.println(" <meta charset='UTF-8'> ");
  	  	out.println(" <title>Error</title> ");
  	  	out.println(" </head> ");
  	  	out.println(" <body> ");
  	  	out.println(" <h1>오류</h1> ");
  	  	out.println(" <p>암호가 올바르지 않습니다다시 입력하세요</p> ");
  	  	out.println(" <form action ='askPassword' action = 'get'> ");
  	  	out.format(" <input type='hidden' name='mno' value='%1$d'",mno);
  	  	out.format(" <input type='hidden' name='destination' value='%1$d'",destination);
  	  	out.println(" <input type='password' name = 'password'> ");
  	  	out.println(" <input type='submit' value='확인'> ");
  	  	out.println(" </form> ");
  	  	out.println(" </body> ");
  	  	out.println(" </html> ");
  		}
  		
  	} catch(Exception e){
    	RequestDispatcher rd = request.getRequestDispatcher("/report0707/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  	
  	
  	
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	try{
  		ServletContext ctx = this.getServletContext();
    	MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
    	
    	Member member = memberDao.get(Integer.parseInt(request.getParameter("no")));
    	int mno = member.getMno();
	  	PrintWriter out = response.getWriter();
	  	
	  	String destination = request.getParameter("destination");
	  	//System.out.println(member);
	  	//System.out.println(mno);
	  	//System.out.println(destination);
	  	
	  	out.println(" <!DOCTYPE html> ");
	  	out.println(" <html> ");
	  	out.println(" <head> ");
	  	out.println(" <meta charset='UTF-8'> ");
	  	out.println(" <title>Insert title here</title> ");
	  	out.println(" </head> ");
	  	out.println(" <body> ");
	  	out.println(" <h1>암호 확인</h1> ");
	  	out.println(" <p>암호를 입력해주세요</p> ");
	  	out.println(" <form action ='askPassword' action = 'post'> ");
	  	out.format(" <input type='hidden' name='mno' value='%1$d'>",mno);
	  	out.format(" <input type='hidden' name='destination' value='%1$s'>",destination);
	  	out.println(" <input type='password' name = 'password'> ");
	  	out.println(" <input type='submit' value='확인'> ");
	  	out.println(" </form> ");
	  	out.println(" </body> ");
	  	out.println(" </html> ");
  	}catch (Exception e){
  		RequestDispatcher rd = request.getRequestDispatcher("/report/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
  	}
  	
  	
  }
}
