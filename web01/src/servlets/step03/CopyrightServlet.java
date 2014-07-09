package servlets.step03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/score/step03/copyright")
public class CopyrightServlet extends HttpServlet{
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	PrintWriter out = response.getWriter();
  	out.println("<address>&copy; by Bit Academy Java56</address>");
  	
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	// doGet, doPost 한번에 처리(service 호출함과 동일)
  	doGet(request,response);
  }
}
