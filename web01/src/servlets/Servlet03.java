package servlets;

// 웹 브라우저로 출력하기
// 1) 출력 스트림 얻기
// 2) 한글 출력하기
//	- 서블릿 컨테이너는 입출력 문자열을 기본적으로 ISO-8859-1로 취급함.
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet03")
public class Servlet03 extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	//HttpServletResponse : 응답에 사용할 도구를 갖추고 있는 객체(도구함).
  	
  	//반드시 출력 스트림을 얻기 전에 콘텐츠 타입을 지정해야한다.
  	response.setContentType("text/html; charset=UTF8");
  	
  	PrintWriter out = response.getWriter();
  	out.println("오호라");
  	out.println("헐.....");
  	out.println("hello");
  	  	
  	//끝.
  	//어짜피 Servlet은 HTML출력하는역할이기때문에
  }
  
}
