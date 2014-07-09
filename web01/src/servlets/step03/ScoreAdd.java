package servlets.step03;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/score/step03/add")
public class ScoreAdd extends HttpServlet{
  private static final long serialVersionUID = 1L;
  
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		//filter로 대체하였음.
		//request.setCharacterEncoding("UTF-8");
		
		Score score= new Score();
		
			score.setName(request.getParameter("name"));
			score.setKor(Integer.parseInt(request.getParameter("kor")));
			score.setEng(Integer.parseInt(request.getParameter("eng")));
			score.setMath(Integer.parseInt(request.getParameter("math")));
			
			//ServletContext에서 꺼내쓰기에 init ( dbcp 등 ),destroy 필요없음
			ServletContext ctx = this.getServletContext();
			ScoreDao scoreDao = (ScoreDao)ctx.getAttribute("scoreDao");
			
		try{
			scoreDao.insert(score);
			
			//1-i) Refresh 정보를 응답 헤더에 넣는다.
			//response.setHeader("Refresh", "1; url=list");
			
			response.setContentType("text/html; charset=UTF-8");
				
			PrintWriter out = response.getWriter();
				
			out.println(" <!DOCTYPE html>");
			out.println(" <html>");
			out.println(" <head>");
			out.println(" <meta charset='UTF-8'>");
			//1-ii) Refresh 정보를 본문에 넣는다.
			//out.println(" <meta http-equiv='Refresh' content='1; url=list'>");
			out.println(" <title>등록 성공</title>");
			out.println(" </head>");
			out.println(" <body>");
			out.println(" <p> 등록되었습니다. </p>");
			
			RequestDispatcher rd = request.getRequestDispatcher("/score/step03/copyright");
			rd.include(request, response);
			
			
			//response.flushBuffer();
			
			out.println(" </body>");
			out.println(" </html>");
			
			//2) 웹 브라우저에게 재요청정보를 전달한다 
			//	-> 본문을 보내지 않는다. ==> 캐시에 보관된 내용물을 버린다.
			response.sendRedirect("list");
			// 왜 태그를 먼저 출력 했는데 본문은 무시하는걸까
			
			// *** PrintWriter 객체를 통해 출력하면 출력 내용은 즉시 웹 브라우저로 보내지지 않는다.
			// 	-> 출력 효율을 위함이다.
			//	( 캐시메모리에 보관 하였다가, 캐시가 꽉 차면 그제서야 출력 한다 )
			//	( 또는 메서드 호출이 끝나면 끝난다. )
			//	( 또는 flush() 를 호출하여 강제로 방출 시킬 수 있다. )
			//	보통 캐시 크기는 8kb이다.
			
			// 만약 캐시가 가득 차거나 flush해서  sendRedirect() 일부 내용을 보냈다면?
			//	-> sendRedirect 할 수 없다 ( 위 참조 )
			
			
		} catch (Exception e){
			//오류가 발생하면 /score/step03/error 서블릿으로 위임
			//	( 요청 배달자를 통해 배달)
			RequestDispatcher rd = request.getRequestDispatcher("/score/step03/error");
			
			//ErrorServlet에 실행을 위임하기 전에 ServletRequest 보관함에 오류 정보를 담아서 보낸다.
			request.setAttribute("error", e);
			
			rd.forward(request, response);
		}
		
	}
	
}
