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

@WebServlet("/finding")
public class FindingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("find");
		DB db = new DB();
		List<Menu> menulist = db.getMenuByTitle(title);
		if (menulist.size() == 0) {
			request.getRequestDispatcher("WEB-INF/pages/nofinding.jsp").forward(request, response);
		} else {
			request.setAttribute("finding", menulist);
			request.getRequestDispatcher("WEB-INF/pages/finding.jsp").forward(request, response);
		}
	}
}
