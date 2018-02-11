package filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import entity.Users;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
		   description="登录过滤",
		   filterName="loginFilter",
		   urlPatterns={"/CartServlet"}
		)
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
	
	
	
	
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
        Users username=(Users) ((HttpServletRequest)request).getSession().getAttribute("user");
        if(username==null)
        {
        	request.setAttribute("status", "请先登录");
        	request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
        else
        {
		// pass the request along the filter chain
		chain.doFilter(request, response);
        }
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
