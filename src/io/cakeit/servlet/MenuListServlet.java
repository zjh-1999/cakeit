package io.cakeit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.cakeit.entity.Menu;
import io.cakeit.util.DB;

@WebServlet("/menuList")
public class MenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DB db = new DB();
		List<Menu> menulist = db.getMenuList();
		request.setAttribute("menulist", menulist);
		request.getRequestDispatcher("WEB-INF/pages/menuList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
