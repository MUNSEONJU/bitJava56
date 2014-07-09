package servlets.step03;

/** 다른 서블릿에서 오류가 발생하면 이 서블릿으로 오류 처리를 위임한다. **/ 
//	-> 다른 서블릿에서 발생한 오류를 출력하는 역할
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/score/step03/error")
public class ErrorServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
  
  //get,post 둘다 한번에 처리하기위해 service로
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	response.setContentType("text/html; charset=UTF-8");
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

		RequestDispatcher rd = request.getRequestDispatcher("/score/step03/copyright");
		rd.include(request, response);
		
		out.println(" </body>");
		out.println(" </html>");
  	
  }
  
}
