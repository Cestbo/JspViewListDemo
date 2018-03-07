<%@page import="dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
   function delcfm() {
	if(!confirm("确定要删除？"))
		window.event.returnValue=false;
}
</script>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<!-- <style type="text/css">
   #shopping table {border-top: 10px solid yellow}
   #shopping table td{border-top: 1px solid yellow}
</style>
 -->
<title>购物车</title>
</head>
<body background="image/background.jpg">

   <!-- 显示购物车情况 -->
   
   <!--商品名称：
   &nbsp;&nbsp;商品数量：  -->
   <h1 style="color: white;">我的购物车</h1>
   <hr>
   <a href="index.jsp" ><big>首页</big></a><span style="color: white;"><big>>>商品列表</big></span>
   
   <div id="shopping">
      <center>
         <table 
         
           class=" table table-striped  table-hover" > 
        
            <tr id="head" >
               <th style="text-align: center;">商品名称</th>
               <th style="text-align: center;">商品单价</th>
               <th style="text-align: center;">商品总价</th>
               <th style="text-align: center;">购买数量</th>
               <th style="text-align: center;">操作</th>
            </tr>
            <!-- 循环部分 -->
            <%
                  CartDao dao=new CartDao();
                  Users User=(Users)request.getSession().getAttribute("user");
                  ItemsDao itemsDao=new ItemsDao();
                  ArrayList<Cart> carts=dao.getAllByUserid(User.getUserid());
                  int total=0;
        	      for(Cart obj:carts)
        	      {
        		    Items item=itemsDao.getItembyNO(obj.getGoodsid());
        		    int num=obj.getNumber();
            %>
            <tr class="item" >
               <td align="center">
                 <a href="details.jsp?id=<%=item.getNo()%>">
                 <img  src="image/<%=item.getPicture()%>" width="120" height="100">
                 </a>
                 &nbsp;&nbsp;&nbsp;&nbsp;
                 <strong><%=item.getName()%></strong>
               </td>
               <td align="center"><br><br>￥<%=item.getPrice() %>元</td>
               <td align="center"><br><br>￥<%=item.getPrice()*num %>元</td>
               <td align="center"><br><br><%=num %></td>
               <td align="center">
               <br><br>
                  <a href="<%=request.getContextPath()%>/CartServlet?action=delete&no=<%=item.getNo() %>&cartid=<%=obj.getCartid() %>"
                  onclick="delcfm()"><span style="background-color: gray;color: blue;">删除</span></a>
               </td>
            </tr>
            <%
               total=total+item.getPrice()*num;
            } 
               
            %>
            <tr>
               <td></td>
               <td></td>
               <td></td>
               <td align="center" style="background-color: gray;color: red;font-size: large;"><strong>总价：￥<%=total %>元</strong></td>
               <td></td>
            </tr>
            
            <!-- 循环部分 -->
         </table>
      </center>
   </div>


</body>
</html>