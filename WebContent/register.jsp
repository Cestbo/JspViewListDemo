<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<script type="text/javascript">
window.onload=function() {
	if("<%=(String)request.getAttribute("isSameName")%>"!="null")
		alert("<%=(String)request.getAttribute("isSameName")%>");
}
function check() {
	
   var name=document.getElementById("name").value;
   var pwd=document.getElementById("pwd").value;
   var surepwd=document.getElementById("surepwd").value;
   var email=document.getElementById("email").value;

   if(name=="" || pwd=="" || surepwd=="" || email=="")
	   {
	     alert("输入框不能为空");
	    
	     return false;
	   }
   if(pwd!=surepwd)
	   {
	     alert("两次输入的密码不同");
	   
	     return false;
	   }
   var rege=/[\u4E00-\u9FA5\w]+@\w+.\w+/;
   if(!rege.test(email))
	   {
	     alert("邮箱格式不对");
	     
	     return false;
	   }
   
	
	   
}
</script>
</head>
<body background="image/background.jpg">
<h1 align="center" style="color: white;">用户注册</h1>
<hr>
<center>
<div   style="border: 1px solid white;
width: 400px;height: 300px;padding: 10px;background-color: white;">
<form name="regForm"  onsubmit=""  method="post" action="<%=request.getContextPath()%>/LoginServlet?action=register">
<table  cellspacing="0" cellpadding="0" style="border-spacing: 10px;border-collapse: separate;">
  <tr>
    <td></td>
 </tr>
 <tr>
    <td></td>
 </tr>
 <tr>
    <th>用&nbsp;&nbsp;户&nbsp;&nbsp;名</th>
    <td><input class="form-control input-sm"  type="text" name="username" id="name"/></td>
 </tr>
 <tr>
    <th>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</th>
    <td><input class="form-control input-sm" type="password" name="password" id="pwd"/></td>
 </tr>

 <tr>
    <th>确认密码</th>
    <td><input class="form-control input-sm"  type="password" name="surepwd" id="surepwd"/></td>
 </tr>
 <tr>
    <th>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</th>
    <td><input class="form-control input-sm"  type="text" name="email" id="email"/></td>
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
   <input class="btn btn-default btn-sm" type="submit"  value="提交" onclick="return check()"/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input class="btn btn-default btn-sm" type="reset" value="重置"></td>
 </tr>
</table>

</form>
</div>
</center>
</body>
</html>