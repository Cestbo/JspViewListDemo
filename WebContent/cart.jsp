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
<title>Insert title here</title>
</head>
<body>

   <!-- 显示购物车情况 -->
   
   <!--商品名称：
   &nbsp;&nbsp;商品数量：  -->
   <h1>我的购物车</h1>
   <a href="index.jsp">首页</a>>><a>商品列表</a>
   <hr>
   <div id="shopping">
      <center>
         <table border="0" cellpadding="0" cellspacing="50" >
         <%
         	if (request.getSession().getAttribute("cart") != null)
         	{
         		Cart cart = (Cart) request.getSession().getAttribute("cart");
         %>
            <tr>
               <th>商品名称</th>
               <th>商品单价</th>
               <th>商品总价</th>
               <th>购买数量</th>
               <th>操作</th>
            </tr>
            <!-- 循环部分 -->
            <%
              
                  HashMap<Items,Integer> goods=cart.getGoods();
                  Set<Map.Entry<Items,Integer>> all=goods.entrySet();
        	      for(Map.Entry<Items, Integer> obj:all)
        	      {
        		    Items item=obj.getKey();
        		    int num=obj.getValue();
            %>
            <tr>
               <td>
                 <a href="details.jsp?id=<%=item.getNo()%>">
                 <img  src="image/<%=item.getPicture()%>" width="100" height="80">
                 </a>
                 <br>
                 <%=item.getName() %>
               </td>
               <td>￥<%=item.getPrice() %>元</td>
               <td>￥<%=item.getPrice()*num %>元</td>
               <td align="center"><%=num %></td>
               <td>
                  <a href="<%=request.getContextPath()%>/CartServlet?action=delete&no=<%=item.getNo() %>"
                  onclick="delcfm()"><span style="background-color: gray;color: blue;">删除</span></a>
               </td>
            </tr>
            <%
            } 
               
            %>
            <tr>
               <td></td>
               <td></td>
               <td></td>
               <td>总价：￥<%=cart.getTotalPrice() %>元</td>
            </tr>
            <%} %>
            <!-- 循环部分 -->
         </table>
      </center>
   </div>


</body>
</html>