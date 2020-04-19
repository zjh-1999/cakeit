package io.cakeit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Menu;
import io.cakeit.util.DB;

@WebServlet("/menuDetail")
public class MenuDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MenuDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DB db = new DB();
		Menu menu = db.getMenuById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("menu", menu);
		HttpSession session=request.getSession();
		session.setAttribute("menu",menu);
		request.getRequestDispatcher("WEB-INF/pages/menuDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
