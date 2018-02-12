<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    Users user=(Users)request.getSession().getAttribute("user");
%>
    <h1>商品展示</h1>
    <%
        if(user==null)
        {
    %>
    <p align="right">您好，欢迎来到淘淘网！&nbsp;&nbsp; [<a href="login.jsp" >登录</a>]&nbsp;[<a href="register.jsp">免费注册</a>]<p>
    <%
        }
        else{
    %>
    <p align="right">亲爱的&nbsp;<mark><%=user.getUsername() %>
    </mark>&nbsp;您好，欢迎来到淘淘网！&nbsp;&nbsp;&nbsp;
    [<a href="<%=request.getContextPath()%>/LoginServlet?action=logout">退出</a>] 
    </p>
    <%
        }
    %>
    <hr>
    
    <center>
    <table width="750" height="120" cellpadding="0" cellspacing="0" border="0" >
      <% 
        ItemsDao dao=new ItemsDao();
        ArrayList<Items> list=dao.getAllitems();
        int size=list.size();
        int count=0;
        for(int i=0;i<(size/4)+1;i++)
        {
      %>
      <tr>
          <% 
             for(int j=0;j<4;j++)
             {
            	 if((4*i+j)<size)
            	 {
            	    Items item=list.get(4*i+j); 
             
          %>
           <td>
             <div>
                <dl>
                   <dt> 
                       <a href="details.jsp?id=<%=item.getNo()%>"><img src="image/<%=item.getPicture()%>" width="120" height="120"></a>
                   </dt>
                   <dd class="dd_name" style="color: blue;"><%=item.getName() %></dd>
                   <dt class="dd_city">產地：<%=item.getCity() %><br>價格：￥<%=item.getPrice() %></dt>
                </dl>
             </div>
            </td>
           <%
            	 }
             }
           %>
      </tr> 
      <%
        }
      %>
    </table>
    </center>
</body>
</html>