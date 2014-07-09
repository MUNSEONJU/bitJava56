package servlets.step01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 컴파일 한 후 .class파일에 주석 정보가 보관된다.
//	( 그래야만 톰캣 서버가 클래스파일로부터 URL 정보를 얻을 것이 아니냐 )

@WebServlet("/score/list")
public class ScoreList extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  DbConnectionPool dbcp;
  ScoreDao scoreDao;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
  	super.init(config); // overriding하기 전의 init
  	
  	try {
	    dbcp = new DbConnectionPool("com.mysql.jdbc.Driver",
	    		"jdbc:mysql://localhost:3306/bitdb?useUnicode=true&characterEncoding=UTF-8",
	        "bit", "1111");
    } catch (Exception e) {
	    e.printStackTrace();
    }
  	scoreDao = new ScoreDao();
  	scoreDao.setDbConnectionPool(dbcp);
  }
  
  @Override
  public void destroy() {
    super.destroy();
    dbcp.closeAll();
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
  	
  	//출력되는 내용을 지정된 문자집합으로 인코딩한다
  	//	- 인코딩 : 문자 집합 명세서에 나와 있는대로 각 문자에 대한 코드값으로 바꾼다
  	//	- 'A' -> 0x41(1byte), '가' -> 0x80xxxx(3byte)
  	response.setContentType("text/html; charset=UTF8");
  	
  	PrintWriter out = response.getWriter();
  	
	out.println(" <!DOCTYPE html>");
	out.println(" <html>");
	out.println(" <head>");
	out.println(" <meta charset='UTF-8'>");
	out.println(" <title>Insert title here</title>");
	out.println(" <style type='text/css'>");
	out.println(" table{");
	out.println(" 	font-family: verdana,arial,sans-serif;");
	out.println(" 	font-size:11px;");
	out.println(" 	color:#333;");
	out.println(" 	border-style:solid;");
	out.println(" 	border-width:1px; ");
  out.println(" 	border-color:#666; ");
  out.println(" 	border-collapse: collapse; ");
  out.println(" } ");
	out.println(" table th { ");
  out.println(" 	border-width: 1px; ");
  out.println(" 	padding: 8px; ");
  out.println(" 	border-style: solid; ");
  out.println(" 	border-color: #666666; ");
  out.println(" 	background-color: #dedede; ");
  out.println(" } ");
	out.println(" table td { ");
  out.println(" 	border-width: 1px; ");
  out.println(" 	padding: 8px; ");
  out.println(" 	border-style: solid; ");
  out.println(" 	border-color: #666666; ");
  out.println(" 	background-color: #ffffff; ");
  out.println(" } ");
	out.println(" </style> ");
	out.println(" </head> ");
	
	out.println(" <body> ");
//	out.println("");
	out.println(" <h1>성적관리</h1> ");

	out.println(" <table> ");
	out.println(" <tr> ");
  out.println(" 	<th>번호</th> <th>이름</th> <th>국어</th> <th>영어</th> <th>수학</th> <th>합계</th> <th>평균</th> <th></th> ");
	out.println(" </tr> ");
	
	try{
		ArrayList<Score> scores = scoreDao.list();
		for(Score score : scores){
			out.println(" <tr> ");
		  out.format("<td><a href='updateform?no=%1$d'>%1$d</a></td>", score.getNo());
			out.format("<td>%1$s</td>", score.getName());
			out.format("<td>%1$d</td>", score.getKor());
			out.format("<td>%1$d</td>", score.getEng());
			out.format("<td>%1$d</td>", score.getMath());
			out.format("<td>%1$d</td>", score.getTotal());
			out.format("<td>%1$.1f</td> ", score.getAverage());
			out.format("<td><a href='delete?no=%1$d'>삭제</a></td>", score.getNo());
			out.println(" </tr> ");
		}
	} catch (Exception e){
		e.printStackTrace();
	}
	out.print(" </table> ");
	
	//out.println("	<a href = ' URL '><input type='submit' value='추가'</a>");
	out.println(" <form action='form.html'> ");
	out.println(" <input type='submit' value='추가'> ");
	out.println(" </form> ");
	
	out.print(" </body> ");
	out.print(" </html> ");
  	
  }
}
