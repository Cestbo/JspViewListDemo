package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDao;
import entity.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if (action.equals("login")) {

			UsersDao dao = new UsersDao();
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Users user = dao.getUserByName(username);
			if (user != null && password.equals(user.getPassword())) {
				request.getSession().setAttribute("user", user);
				// 使用cookies保存用户名和密码
				saveUserCookies(request, response);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				request.setAttribute("prompt", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

		if (action.equals("logout")) {
			request.getSession().removeAttribute("user");
			response.sendRedirect("index.jsp");
		}

		if (action.equals("register")) {
			UsersDao dao1 = new UsersDao();
			String username1 = request.getParameter("username");
			Users test = dao1.getUserByName(username1);
			if (test == null) {

				String password1 = request.getParameter("password");
				String email = request.getParameter("email");
				java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
				Users user = new Users(0, username1, password1, email, timestamp);
				dao1.addUser(user);
				request.getSession().setAttribute("user", user);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("isSameName", "存在该用户");
				request.getRequestDispatcher("register.jsp")
				.forward(request, response);
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void saveUserCookies(HttpServletRequest request, HttpServletResponse response) {

		String[] usercookie = request.getParameterValues("iscookie");
		if (usercookie != null && usercookie.length > 0) {
			String name = request.getParameter("username");
			try {
				name = URLEncoder.encode(name, "utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Cookie username = new Cookie("username", name);
			Cookie password = new Cookie("password", request.getParameter("password"));
			username.setMaxAge(60 * 60 * 24);
			password.setMaxAge(60 * 60 * 24);

			response.addCookie(username);
			response.addCookie(password);

		} else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null && cookies.length > 0) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().equals("username") || cookies[i].getName().equals("password")) {
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
					}
				}
			}
		}

	}

}
