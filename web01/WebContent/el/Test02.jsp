<%@page import="servlets.step04.Score"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 검색범위</title>
</head>
<body>
<h1>EL 검색 범위</h1>

<%-- 
* EL - 객체를 찾는 순서
  - ${객체명.프로퍼티명}
    : 로컬 변수에서는 찾지 않는다.
    : JspContext -> ServletRequest -> HttpSession -> ServletContext
  
  - ${scope.객체명.프로퍼티명} 
    : 구체적으로 객체를 찾는 보관소를 지정할 수 있다.
    : pageScope(JspContext), requestScope(ServletRequest)
      , sessionScope(HttpScope), applicationScope(Servletcontext)

--%>

<jsp:useBean id="score" class="servlets.step04.Score" scope="page">
  <jsp:setProperty name="score" property="name" value="홍길동"/>
  <jsp:setProperty name="score" property="kor" value="100"/>
  <jsp:setProperty name="score" property="eng" value="90"/>
  <jsp:setProperty name="score" property="math" value="80"/>
</jsp:useBean>


<%-- 동일한 이름으로 page와 request에 각각 다른 데이터를 저장. --%>
<% 
Score temp = new Score();
score.setName("임꺽정");
request.setAttribute("score", temp);
%>

pageScope.score.name : ${pageScope.score.name}<br/>
requestScope.score.name : ${requestScope.score.name}<br/>
sessionScope.score.name : ${sessionScope.score.name}<br/>
applicationScope.score.name : ${applicationScope.score.name}<br/>
score.name : ${score.name}<br/>

<%-- 
* EL의 특장점(NullPointerException 발생안함) 
  - 객체를 찾지 못해도 ( null ) 오류가 발생하지 않는다.
--%>
보관소에 없는 객체를 지정하기: ${okok.name}<br/>
<%-- ((Score)request.getAttribute("okok")).getName(); --%>

</body>
</html>