<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html>      
 <html>  
 <head>  
 <meta charset="UTF-8">  
 <title>회원정보추가</title>  
 </head>  
 <body>
 <h1>회원정보추가</h1>  
 <form action ='add' method = 'post'>  
 이름 : <input type='text' name ='name' placeholder="input name"><br/>  
 메일 : <input type='text' name ='email' placeholder="input e-mail"><br/>  
 전화 : <input type='text' name ='tel' placeholder="input Tel.number"><br/>  
 암호 : <input type='password' name = 'pwd' placeholder="input password"><br/>  
 <input type='submit' value='등록'>  
 </form>  
 </body>  
 </html> 