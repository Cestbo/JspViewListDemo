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
    <h1>商品展示</h1>
    <hr>
    
    <center>
    <table width="750" height="120" cellpadding="0" cellspacing="0" border="0">
       <tr>
         
          <%
              ItemsDao dao=new ItemsDao();
              ArrayList<Items> list=dao.getAllitems();
              if(list!=null && list.size()>0)
              {
                 for(Items item:list)
                   {
             
          %> 
           <td>
             <div>
                <dl>
                   <dt> 
                       <a href="details.jsp"><img src="image/<%=item.getPicture()%>" width="120" height="120"></a>
                   </dt>
                   <dd class="dd_name" style="color: blue;"><%=item.getName() %></dd>
                   <dd class="dd_city">產地：<%=item.getCity() %>&nbsp;&nbsp;價格：￥<%=item.getPrice() %></dd>
                </dl>
             </div>
             </td>
           <%
                 }
              }
           %>
          
       </tr>
    </table>
    </center>
</body>
</html>