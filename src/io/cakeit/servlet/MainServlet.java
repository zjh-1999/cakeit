package io.cakeit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Menu;
import io.cakeit.util.DB;

@WebServlet(name = "main", urlPatterns = { "/main" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String islogin=(String)session.getAttribute("islogin");
		if(islogin==null) {
			request.setAttribute("first","登录");
			request.setAttribute("second","注册");
		}
		else {
			request.setAttribute("first", "欢迎您");
			request.setAttribute("second", "退出");
		}
		DB db = new DB();
		List<Menu> menulist = db.bestMenu();
		request.setAttribute("menulist", menulist);
		request.getRequestDispatcher("WEB-INF/pages/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
