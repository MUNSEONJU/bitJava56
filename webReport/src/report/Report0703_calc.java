package report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/0703_calc")
public class Report0703_calc extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	String operator = request.getParameter("operator");
  	float value1 = Float.parseFloat(request.getParameter("value1"));
  	float value2 = Float.parseFloat(request.getParameter("value2"));
  	Float result=0f;
  	
  	response.setContentType("text/html; charset=UTF-8");
  	
  	PrintWriter out = response.getWriter();
  	
  	if(operator.equals("plus")){
  		result = value1+value2;
  		operator = "+";
  	} else if(operator.equals("minus")){
  		result = value1-value2;
  		operator = "-";
  	} else if(operator.equals("multiple")){
  		result = value1*value2;
  		operator = "×";
  	} else if(operator.equals("divine")){
  		result = value1/value2;
  		operator = "÷";
  	}
  	
  	out.print(value1 + operator + value2 + "의 결과는 " + result + "입니다");
  	
  }

}
