package report.report0707;

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

@WebServlet("/report0707/member/list")
public class MemberList extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
  		throws ServletException ,IOException {
  	
  	PrintWriter out = response.getWriter();
		
  	out.println(" <!DOCTYPE html>");
  	out.println(" <html>");
  	out.println(" <head>");
  	out.println(" <meta charset='UTF-8'>");
		
		out.printf(" <style type = 'text/css'> ");
		out.println(" table{");
		out.println(" 	font-family: verdana,arial,sans-serif;");
		out.println(" 	font-size:11px;");
		out.println(" 	color:#333;");
		out.println(" 	border-style:solid;");
		out.println(" 	border-width:1px; ");
	  out.println(" 	border-color:#666; ");
	  out.println(" 	border-collapse: collapse; ");
	  out.println(" } ");
		out.println(" table th { ");
	  out.println(" 	border-width: 1px; ");
	  out.println(" 	padding: 8px; ");
	  out.println(" 	border-style: solid; ");
	  out.println(" 	border-color: #666666; ");
	  out.println(" 	background-color: #dedede; ");
	  out.println(" } ");
		out.println(" table td { ");
	  out.println(" 	border-width: 1px; ");
	  out.println(" 	padding: 8px; ");
	  out.println(" 	border-style: solid; ");
	  out.println(" 	border-color: #666666; ");
	  out.println(" 	background-color: #ffffff; ");
	  out.println(" } ");
		out.printf(" </style> ");
		
		out.printf(" <title>회원 관리</title> ");
		out.printf(" </head> ");
		out.printf(" <body> ");
		out.printf(" <h1>회원</h1> ");
		out.printf(" 	<table> ");
		out.printf(" 		<tr> ");
		out.printf(" 		  <th>일련번호</th> <th>이름</th> <th>이메일</th> <th>전화번호</th> <th></th> ");
		out.printf(" 		</tr> ");
				
		try{
			ServletContext ctx = this.getServletContext();
			MemberDao memberDao = (MemberDao) ctx.getAttribute("memberDao");
			ArrayList<Member> members = memberDao.load();
			
			for(Member member : members){
				out.println(" <tr> ");
			  out.format("<td>%1$d</td>", member.getMno());
				out.format("<td><a href='update?no=%1$d&destination=%3$s'>%2$s</a></td>",member.getMno() ,member.getName(),"update");
				out.format("<td>%1$s</td>", member.getEmail());
				out.format("<td>%1$s</td>", member.getTel());
				out.format("<td><a href='delete?no=%1$d&destination=%2$s'>삭제</a></td>", member.getMno(),"delete");
				out.println(" </tr> ");
			}
			
			/*
			for(int i=0;i<members.size();i++){
				Member member = members.get(i);
				out.printf("     <tr> ");
				out.printf("       <td>%1$d</td> ", member.getMno()); 
				out.format("<td><a href='update?no=%1$d'>%2$s</a></td>",member.getMno() ,member.getName());
				out.printf("       <td>%1$s</td> ", member.getEmail()); 
				out.printf("       <td>%1$s</td> ", member.getTel()); 
				out.printf("       <td><a href = 'delete?mno=%1$d'>삭제</a></td>",member.getMno());
				out.printf("     </tr> ");
			} 
			*/
			
			out.println(" <form action = 'add' method = 'get'> ");
			out.println(" <input type='submit' value='추가'> ");
			out.println(" </form> ");
		}catch (Exception e){
			RequestDispatcher rd = request.getRequestDispatcher("/report0707/member/error");
  		request.setAttribute("error", e);
  		rd.forward(request, response);
		}
		
		
		out.printf("   </table> ");
		out.printf(" </body> ");
		out.printf(" </html> ");
  }
}
