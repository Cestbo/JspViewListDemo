<%@page import="java.awt.Font"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.*"
         import="java.util.*"
         import="javax.imageio.ImageIO"
%>
<% 
   int width=60,height=20;
   BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
   //获取画笔
   Graphics g=image.getGraphics();
   //设置背景色
   g.setColor(new Color(200,200,200));
   g.fillRect(0, 0, width, height);
   //取随机验证码
   Random random=new Random();
   int ranNum=random.nextInt(9000)+1000;
   String ranStr=String.valueOf(ranNum);
   //将随机码存入session
   session.setAttribute("ranStr", ranStr);
   //将验证码显示到图片中
   g.setColor(Color.black);
   g.setFont(new Font("",Font.PLAIN,20));
   g.drawString(ranStr, 10, 17);
   //随机产生100个干扰点让其不易被程序探测到
   for(int i=0;i<100;i++)
   {
	   int x=random.nextInt(width);
	   int y=random.nextInt(height);
	   g.drawOval(x, y, 1, 1);
	   
   }
   //输出图像到页面
   ImageIO.write(image, "JPEG", response.getOutputStream());
   out.clear();
   out=pageContext.pushBody();
   
%>