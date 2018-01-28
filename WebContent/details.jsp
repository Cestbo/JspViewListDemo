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
    <h1>商品详情</h1>
   
     <hr>
    <center>
    <table width="750" height="120" cellpadding="0" cellspacing="0" border="0">
       <tr>
         
          <%
              ItemsDao dao=new ItemsDao();
              Items item=dao.getItembyNO(Integer.valueOf(request.getParameter("id")));
              if(item!=null)
              {
          %> 
           <td align="left" valign="top">
           
             <div>
                <dl>
                   <dt> 
                       <img src="image/<%=item.getPicture()%>" width="240" height="240">
                   </dt>
                   <dd class="dd_name" style="color: blue;"><%=item.getName() %></dd>
                   <dd class="dd_city">產地：<%=item.getCity() %>&nbsp;&nbsp;價格：￥<%=item.getPrice() %></dd>
                   <dd>库存量：<%=item.getNumber() %></dd>
                </dl>
             </div>
             </td>
           <%
              }
           %>
           <!-- 浏览过的商品 -->
           <td width="30%" bgcolor="gray" align="center">
               <br>
               <b>您浏览过的商品</b>
               <hr>
               <%
                   String list="";
                   //逆序添加记录
                   list=request.getParameter("id")+","+list;
                   Cookie[] cookies=request.getCookies();
                   if(cookies!=null && cookies.length>0)
                   {
                   for(Cookie c:cookies)
                   {
                	   if(c.getName().equals("ListViewCookie"))
                	   {
                		   list=list+c.getValue();
                	   }
                   }
                   }
                   String[] arr=list.split(",");
                   //保存前五条记录
                   if(arr.length>5)
                   {
                	   list="";
                	   for(int i=0;i<5;i++)
                	   {
                		   list=list+arr[i]+",";
                	   }
                   }
                   Cookie cookie=new Cookie("ListViewCookie",list);
                   response.addCookie(cookie);
                   ItemsDao dao2=new ItemsDao();
                   ArrayList<Items> views=dao.getViewList(list);
                   for(Items I:views)
                   {
                	   
               %>
               <div>
               <dl>
                   
                      <dd> <a href="details.jsp?id=<%=I.getNo() %>"><img src="image/<%=I.getPicture() %>" width="120" height="120"></a></dd>
                  
                      <dd>  <%=I.getName() %></dd>
               </dl>
               </div>
               <%
                   }
               %>
           </td>
          
       </tr>
    </table>
    </center>
</body>
</html>