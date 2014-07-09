<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>      
 <html>  
 <head>  
 <meta charset="UTF-8">  
 <title>회원정보수정</title>  
 </head>  
 <body>
 <h1>회원정보수정</h1>  
 <jsp:useBean id="member" scope="request" class="report.report0708.Member"></jsp:useBean>
 <form action ='update' method = 'post'> 
 번호 : <input type='text' name ='mno' value="<%=member.getMno()%>" readonly><br/>  
 이름 : <input type='text' name ='name' value="<%=member.getName()%>"><br/>  
 메일 : <input type='text' name ='email' value="<%=member.getEmail()%>"><br/>  
 전화 : <input type='text' name ='tel' value="<%=member.getTel()%>"><br/>  
 암호 : <input type='password' name = 'pwd'><br/>  
 <input type='submit' value='등록'>  
 </form>  
 </body>  
 </html> 