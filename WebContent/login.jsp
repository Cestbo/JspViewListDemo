<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="jquery.js"></script>
<%
   String prompt=(String)request.getAttribute("prompt");
   
%>
<script type="text/javascript">

function info(prompt)
		{
	
		   
	       if(prompt!='null')
	         alert(prompt);  
		}
		
function refresh() {
//后面必须加一个随机的参数，否则验证码将不会刷新
	
   imgValidate.src="validate.jsp?"+Math.random();	
}
//改变鼠标型形状

</script>
</head>
<body onload="info('<%=prompt %>')" background="image/background.jpg" >
<h1 align="center" style="color: white;">用户登录</h1>
<hr>
<%
   String username="";
   String password="";
   Cookie[] cookies=request.getCookies();
	if(cookies!=null&&cookies.length>0)
	{
	for(int i=0;i<cookies.length;i++)
	{
		if(cookies[i].getName().equals("username"))
		{
			
			username=cookies[i].getValue();
			username=URLDecoder.decode(username, "utf-8");
		}
		if(cookies[i].getName().equals("password"))
		{
			password=cookies[i].getValue();
		}
	}
	}
%>
<center>
<div   style="border: 1px solid white;
width: 400px;height: 250px;padding: 10px;background-color: white;">
<form name="regForm"  action="<%=request.getContextPath()%>/LoginServlet?action=login"  method="post" >
<table  cellspacing="0" cellpadding="0" style="border-spacing: 10px;border-collapse: separate;">
 <tr>
    <th>用户名</th>
    <td><input class="form-control input-sm"  type="text" name="username" value="<%=username%>"/></td>
 </tr>
 <tr>
    <th>密&nbsp;&nbsp;&nbsp;&nbsp;码</th>
    <td><input class="form-control input-sm" type="password" name="password" value="<%=password%>"/></td>
</tr>
<tr>
     <th>验证码</th>
     <td>
     <input class="form-control input-sm" type="text" name="code">
    
     
     </td>
</tr>
<!-- 验证码 -->
<tr>
  <td></td>
  <td colspan="1" >
  <img name="imgValidate" src="validate.jsp" 
  style="cursor: pointer;"
  onclick="refresh()" >
  </td>
</tr>
<tr>
       <td><input type="checkbox" name="iscookie" />记住账号和密码</td>
   
</tr>
<tr>
   <td colspan="1"><input class="btn btn-default btn-sm" type="submit"  value="提交"/></td>
   <td colsapn="1"><input class="btn btn-default btn-sm" type="reset" value="重置"></td>
</tr>
</table>

</form>
</div>
</center>
</body>
</html>