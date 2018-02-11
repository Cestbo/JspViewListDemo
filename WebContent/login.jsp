<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1 align="center">用户登录</h1>
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
width: 400px;height: 200px;padding: 10px;background-color: gray;">
<form name="regForm"  action="<%=request.getContextPath()%>/LoginServlet"  method="post" >
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