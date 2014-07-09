package report;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.webkit.ContextMenu.ShowContext;

@WebServlet("/0703_conversion")
public class Report0703_conversion extends HttpServlet {
		
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	processRequest(request, response);
	
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	processRequest(request, response);
}

private void processRequest(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF8");
	
		String text = request.getParameter("text1");
		double textValue=0;
		String measure1 = request.getParameter("measure1");
		String measure2 = request.getParameter("measure2");
		double result = 0;
		
		/*초기화*/
		/*
		request.setAttribute("m1Sel1", "");
		request.setAttribute("m1Sel2", "");
		request.setAttribute("m1Sel3", "");
		request.setAttribute("m1Sel4", "");
		request.setAttribute("m1Sel5", "");
		request.setAttribute("m2Sel1", "");
		request.setAttribute("m2Sel2", "");
		request.setAttribute("m2Sel3", "");
		request.setAttribute("m2Sel4", "");
		request.setAttribute("m2Sel5", "");*/
		
		
		
		if(measure1.equals("cm")){
			textValue*=100;
		} else if(measure1.equals("inch")){
			textValue*=39.370079;
		} else if(measure1.equals("yd")){
			textValue*=1.093613;
		} else if(measure1.equals("km")){
			textValue*=0.001;
		} 
		
		try{
			if(text!=""){
				textValue = Double.parseDouble(text);
				request.setAttribute("textValue", text);
				request.setAttribute("result", text);
			} else{
				textValue = 0;
				request.setAttribute("textValue","");
				request.setAttribute("result", text);
			}
		} catch (Exception e){
			request.setAttribute("result", "올바른 값이 아닙니다");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/report/0703_conversion.jsp");
		rd.include(request, response);
}

}
