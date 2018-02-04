<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%@ page import="entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="jquery.js"></script>
<script type="text/javascript">

    $(document).ready(function()
    		{
    	       var t=$("#number");
    	       var total=$("#store").text();
    	       $("#inc").click(function(){       
    	           t.val(parseInt(t.val())+1)
    	           setTotal();
    	       })
    	       $("#dec").click(function(){
    	           t.val(parseInt(t.val())-1)
    	           setTotal();
    	       })
    	       
    	       $("#cart").click(function() {
    	    	   var tt = $("#number").val();
    	    	   if(tt>parseInt(total))
	        	   {
	        	   alert('库存量不足！');
	        	   }
    	    	   else
    	    	 {
    	    		   alert('添加成功');
    	    		   
    	   	     }
			})
    	       
    	         function setTotal(){
    	          var tt = $("#number").val();
    	          
    	           if(tt<=0){
    	           alert('输入的值错误！');
    	           t.val(parseInt(t.val())+1)
    	           }
    	           if(tt>parseInt(total))
    	        	   {
    	        	   alert('输入的值错误！');
        	           t.val(parseInt(t.val())-1)
    	        	   }
    	       }
    	       
    		})
</script>
 <style type="text/css">
    #number {
       width:30px;
    }
 </style>
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
                   <dd>库存量：<span id="store"><%=item.getNumber() %></span></dd>
                   
                </dl>
             </div>
                                          购买数量<span>
                        <input type="button" value="-" id="dec">
                        <input type="text" value="1" id="number" >
                        <input type="button" value="+" id="inc">
                   </span>
              <br/>
              <br>
             <span>
                <button type="button" >立即购买</button>
                <button type="button" id="cart">加入购物车</button>
                <button type="button" >查看购物车</button>
             </span>
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