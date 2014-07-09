package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/step04/Calc")
public class Servlet06 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//클라이언트가 보낸 데이터가 어떤 문자 집합으로 Encoding 되었는지 톰캣서버에게 알림
		//request.setCharacterEncoding("UTF-8");
		
		float v1 = Float.parseFloat(request.getParameter("v1"));
		float v2 = Float.parseFloat(request.getParameter("v2"));
		String op = request.getParameter("op");
		float result = 0;

		switch(op){
		case "+":
			result = v1+v2;
			break;
		case "-":
			result = v1-v2;
			break;
		case "*":
			result = v1*v2;
			break;
		case "/":
			result = v1/v2;
			break;
		}
		
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>계산결과</title>");
		out.println("</head>");
		out.println("<body>");
		//out.println("	v1 op v1 = result");
		//format syntax 참조
		out.format(" %1$.2f %2$s %3$.2f = %4$.2f \n", v1,op,v2,result);
		out.println("</body>");
		out.println("</html>");
		
	}

}
