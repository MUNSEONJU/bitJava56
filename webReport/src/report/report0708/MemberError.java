package report.report0708;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/report0708/error")
public class MemberError extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println(" <!DOCTYPE html>");
		out.println(" <html>");
		out.println(" <head>");
		out.println(" <meta charset='UTF-8'>");
		out.println(" <title>실행 오류</title>");
		out.println(" </head>");
		out.println(" <body>");
		out.println(" <p> 실행중 오류가 발생하였습니다. </p>");
		
		out.println(" <pre>");
		Exception e = (Exception)request.getAttribute("error");
		e.printStackTrace(out);
		out.println(" </pre>");

		out.println(" <input type = 'submit' value = '돌아가기'>");

		out.println(" </body>");
		out.println(" </html>");
		
	}
	
}
