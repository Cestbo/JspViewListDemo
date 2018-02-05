package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ItemsDao;
import entity.Cart;
import entity.Items;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ItemsDao dao=new ItemsDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		if(action.equals("add"))
		{
			addtoCart(request, response);
			response.sendRedirect(request.getHeader("Referer"));
		}
		if(action.equals("show"))
		{
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
		if(action.equals("delete"))
		{
			String no=request.getParameter("no");
			if(request.getSession().getAttribute("cart")==null)
			{
				Cart cart=new Cart();
				
				request.getSession().setAttribute("cart", cart);
			}
			
			Cart cart=(Cart)request.getSession().getAttribute("cart");
			cart.removeGoods(dao.getItembyNO(Integer.parseInt(no)));
			response.sendRedirect(request.getHeader("Referer"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	//添加商品到购物车
	private void addtoCart(HttpServletRequest request, HttpServletResponse response) {
		
		String no=request.getParameter("no");
		String num=request.getParameter("number");
		Items item=dao.getItembyNO(Integer.parseInt(no));
		
		if(request.getSession().getAttribute("cart")==null)
		{
			Cart cart=new Cart();
			
			request.getSession().setAttribute("cart", cart);
		}
		
		Cart cart=(Cart)request.getSession().getAttribute("cart");
		cart.addGoods(item, Integer.parseInt(num));
		
	}
	
	
}
