package servlets;

// // single line 주석
//	- 컴파일러가 무시하는 주석 ( 바이트코드에 포함되지 않음 )

// /* multi line 주석*/
//	- 컴파일러가 무시하는 주석 ( 바이트코드에 포함되지 않음 )

// @xxx Annotation
//	- 컴파일러나 JVM에게 전달하는 특별한 주석
//	- 바이트코드에 주석을 남길 수 있음 ( 바이트코드에서 Annotation을 추출할 수 있음 )


// @Override Annotation
//	- 컴파일러에게 전달하는 주석
//	- 바이트코드에 포함되지 않는다
//	- super class의 method를 overriding한 것을 선언한다.
//	- 컴파일러는 해당 메서드가 정말 super class에 있는지 검사한다.
//	- superclass에 메서드가 존재하지 않으면 메서드 정의가 불가능하다

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial") // serial에 관련한 오류는 무시해라
@WebServlet("/step04/UnitConv")
public class Servlet07 extends HttpServlet {
	
	static final String[] units = {"cm","inch","yd","km"}; 
	// 변하지 않는 값이니까 메서드 안에서 빼고 인스턴스 생성없이 사용 
	
	@Override // 컴파일러에게 검사한번 해달라고 요청한다
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		float v = 0;
		int from=1 , to=1;
		float result = 0;
		
		String[] fromSelected = { "","","","" };
		String[] toSelected = { "","","","" };
		
		try{
			v = Float.parseFloat(request.getParameter("v"));
		} catch(Exception e){
		}
		try{
			from = Integer.parseInt(request.getParameter("from"));
			fromSelected[from]="selected";
		}catch(Exception e){}
		try{
			to = Integer.parseInt(request.getParameter("to"));
			toSelected[to]="selected";
		}catch(Exception e){}
		
		
		if(from==0 && to==0){
			//cm -> inch
			result = v * 0.39f;
		}
		
		response.setContentType("text/html; charset=UTF8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>UnitConversion</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>단위변환</h1>");
		out.println("<form action=\"UnitConv\" method=\"post\">");
		if(v==0){
			out.println("<input type=\"text\" name=\"v\">");			
		} else {			
			out.println("<input type=\"text\" name='v' value='"
					+ v + "'>");			
		}
		out.println("<select name=\"from\">");
		out.println("<option value='0' "+fromSelected[0]+">cm</option>");
		out.println("<option value='1' "+fromSelected[1]+ ">inch</option>");
		out.println("<option value='2' " +fromSelected[2]+">yd</option>");
		out.println("<option value='3' " +fromSelected[3]+">km</option>");
		out.println("</select>");
		out.println("<select name=\"to\">");
		out.println("<option value='0' "+toSelected[0]+ ">cm</option>");
		out.println("<option value='1' " +toSelected[1]+">inch</option>");
		out.println("<option value='2' " +toSelected[2]+">yd</option>");
		out.println("<option value='3' "+toSelected[3]+ ">km</option>");
		out.println("</select>");
		out.println("<input type=\"submit\" value=\"변환\">");
		out.println("</form>");
		if(v != 0) out.format( "%1$.1f %2$s -> %3$.1f %4$s", v, units[from], result, units[to]);
		out.println("</body>");
		out.println("</html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

	
}
