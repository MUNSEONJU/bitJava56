<%-- 
JSTL( JSP Standard Tag Library )
  -> JSP 페이지를 작성할 때 사용할 수 있는 추가 라이브러리
  -> 다양한 자바 문법을 표현할 수 있는 태그가 있다.
  -> JSP에서 직접 DBMS에 질의를 할 수 있는 태그도 있다.
--%>

<%@page import="servlets.step04.Score"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset='UTF-8'>
 <title>성적 관리(MVC)</title>
 <style type='text/css'>
 table{
  font-family: verdana,arial,sans-serif;
  font-size:11px;
  color:#333;
  border-style:solid;
  border-width:1px; 
  border-color:#666; 
  border-collapse: collapse; 
 } 
 table th { 
  border-width: 1px; 
  padding: 8px; 
  border-style: solid; 
  border-color: #666666; 
  background-color: #dedede; 
 } 
 table td { 
  border-width: 1px; 
  padding: 8px; 
  border-style: solid; 
  border-color: #666666; 
  background-color: #ffffff; 
 } 
 </style> 
 </head> 
 <body> 
 <h1>성적관리(JSTL + EL)</h1> 
 <table> 
 <tr> 
   <th>번호</th> 
   <th>이름</th> 
   <th>국어</th> 
   <th>영어</th> 
   <th>수학</th> 
   <th>합계</th> 
   <th>평균</th> 
   <th>   </th> 
 </tr>
 
 <c:forEach var="score" items="${scores}">
	<tr> 
	  <td><a href='update?no=${score.no}'>${score.no}</a></td>
	  <td>${score.name}</td>
	  <td>${score.kor}</td>
	  <td>${score.eng}</td>
	  <td>${score.math}</td>
	  <td>${score.total}</td>
	  <td>${score.average}</td>
	  <td><a href='delete?no=${score.no}'>삭제</a></td> 
	</tr> 
 </c:forEach>
 </table>  
 <form action='scoreForm.html'> 
 <input type='submit' value='추가'> 
 </form> 
 <jsp:include page="/score/step04/copyright.jsp"></jsp:include>
 </body>  
 </html> 