package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex")
public class ex implements Servlet{
	@Override
	public void service(ServletRequest request, ServletResponse response)
	    throws ServletException, IOException {
	 
	  String st = request.getParameter("exam");
		
	  System.out.println(st);
	  
		response.setContentType("text/text");
		
		PrintWriter out = response.getWriter();
		out.print(" <!DOCTYPE html>");
		out.print(" <html>");
		out.print(" <head>");
		out.print(" <meta charset='UTF-8'>");
		out.print(" <title>Insert title here</title>");
		out.print(" <style type='text/css'>");
		out.print(" table{");
		out.print(" 	font-family: verdana,arial,sans-serif;");
		out.print(" 	font-size:11px;");
		out.print(" 	color:#333;");
		out.print(" 	border-style:solid;");
		out.print(" 	border-width:1px; ");
	  out.print(" 	border-color:#666; ");
	  out.print(" 	border-collapse: collapse; ");
	  out.print(" } ");
		out.print(" table th { ");
	  out.print(" 	border-width: 1px; ");
	  out.print(" 	padding: 8px; ");
	  out.print(" 	border-style: solid; ");
	  out.print(" 	border-color: #666666; ");
	  out.print(" 	background-color: #dedede; ");
	  out.print(" } ");
		out.print(" table td { ");
	  out.print(" 	border-width: 1px; ");
	  out.print(" 	padding: 8px; ");
	  out.print(" 	border-style: solid; ");
	  out.print(" 	border-color: #666666; ");
	  out.print(" 	background-color: #ffffff; ");
	  out.print(" } ");
		out.print(" </style> ");
		out.print(" </head> ");
		out.print(" <body> ");
		out.print(" <h1> 성적관리  </h1> ");
		out.print(" <table> ");
		out.print(" <tr> ");
	  out.print(" 	<th>번호</th> <th>이름</th> <th>국어</th> <th>영어</th> <th>수학</th> <th>합계</th> <th>평균</th> ");
		out.print(" </tr> ");
		out.print(" <tr> ");
	  out.print(" 	<td>1</td> <td>홍길동</td> <td>100</td> <td>90</td> <td>80</td> <td>270</td> <td>75</td> ");
		out.print(" </tr> ");
		out.print(" <tr> ");
	  out.print(" 	<td>1</td> <td>홍길동</td> <td>100</td> <td>90</td> <td>80</td> <td>270</td> <td>75</td> ");
		out.print(" </tr> ");
		out.print(" </table> ");
		out.print(" </body> ");
		out.print(" </html> ");
		
	}

	@Override
  public void destroy() {
	  // TODO Auto-generated method stub
	  
  }

	@Override
  public ServletConfig getServletConfig() {
	  // TODO Auto-generated method stub
	  return null;
  }

	@Override
  public String getServletInfo() {
	  // TODO Auto-generated method stub
	  return null;
  }

	@Override
  public void init(ServletConfig arg0) throws ServletException {
	  // TODO Auto-generated method stub
	  
  }
}
