<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
String[] selected1 = {"","","","",""};
String[] selected2 = {"","","","",""};
String m1 = request.getParameter("measure1");
String m2 = request.getParameter("measure2");
int index = Integer.parseInt(m1);
selected1[index]="selected";
index = Integer.parseInt(m2);
selected2[index]="selected";
/*	
  for(int i=0;i<selected.length;i++){
		selected[i]="";
	}
*/
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method = post action = "/web01/0703_conversion">
  <input type = "text" name = "text1" 
  value = "${textValue}"></input>
  <select name = "measure1">
    <option value="0" <%=selected1[0]%>> m </option>
    <option value="1" <%=selected1[1]%>> cm </option>
    <option value="2" <%=selected1[2]%>> km </option>
    <option value="3" <%=selected1[3]%>> inch </option>
    <option value="4" <%=selected1[4]%>> yd </option>
  </select>
  <label>-></label>
  <select name = "measure2">
    <option value="0" <%=selected2[0]%>> m </option>
    <option value="1" <%=selected2[1]%>> cm </option>
    <option value="2" <%=selected2[2]%>> km </option>
    <option value="3" <%=selected2[3]%>> inch </option>
    <option value="4" <%=selected2[4]%>> yd </option>
   </select>
   <input type="submit" value = "변환">
   <label>${result}</label>
</form>
</body>
</html>