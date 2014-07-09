<%@page import="report.report0708.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>
 <html>
 <head>
 <meta charset='UTF-8'>
 <style type = 'text/css'>  
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
 <title>회원 관리</title>  
 </head>  
 <body>  
 <h1>회원관리시스템</h1>   
 <table>     
  <tr>        
	  <th>일련번호</th> 
	  <th>이름</th> 
	  <th>이메일</th> 
	  <th>전화번호</th> 
	  <th></th>      
  </tr>  
  <jsp:useBean id="members" type="java.util.ArrayList<Member>" scope="request">
  </jsp:useBean>
  <%
  for(Member member : members){
  %>
 
  <tr> 
    <td><%=member.getMno()%></td>
    <td><a href='update?mno=<%=member.getMno()%>'><%=member.getName()%></a></td>
    <td><%=member.getEmail()%></td>
    <td><%=member.getTel()%></td>
    <td><a href='delete?mno=<%=member.getMno()%>'>삭제</a></td> 
  </tr> 
  <%} %>
 </table>
 <form action = 'MemberAdd.jsp' method = 'get'> 
 <input type='submit' value='추가'> 
 </form> 
 </body>  
 </html> 