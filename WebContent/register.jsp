<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body background="image/background.jpg">
<h1 align="center" style="color: white;">用户注册</h1>
<hr>
<center>
<div   style="border: 1px solid white;
width: 400px;height: 300px;padding: 10px;background-color: white;">
<form name="regForm"  action="<%=request.getContextPath()%>/LoginServlet?action=register"  method="post" >
<table  cellspacing="0" cellpadding="0" style="border-spacing: 10px;border-collapse: separate;">
  <tr>
    <td></td>
 </tr>
 <tr>
    <td></td>
 </tr>
 <tr>
    <th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th>
    <td><input class="form-control input-sm"  type="text" name="username" /></td>
 </tr>
 <tr>
    <th>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</th>
    <td><input class="form-control input-sm" type="password" name="password" /></td>
 </tr>

 <tr>
    <th>确认密码</th>
    <td><input class="form-control input-sm"  type="text" name="surepwd" /></td>
 </tr>
 <tr>
    <th>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</th>
    <td><input class="form-control input-sm"  type="text" name="email" /></td>
 </tr>
 <tr>
    <td></td>
 </tr>
  <tr>
    <td></td>
 </tr>
  <tr>
    <td></td>
 </tr>
 <tr>
   <td colspan="2" align="center">
   <input class="btn btn-default btn-sm" type="submit"  value="提交"/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input class="btn btn-default btn-sm" type="reset" value="重置"></td>
 </tr>
</table>

</form>
</div>
</center>
</body>
</html>