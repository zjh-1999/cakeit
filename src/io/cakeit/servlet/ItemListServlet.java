package io.cakeit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Item;
import io.cakeit.util.DB;

@WebServlet("/ItemList")
public class ItemListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ItemListServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("islogin") == null) {
			request.getRequestDispatcher("WEB-INF/pages/noSignUp.jsp").forward(request, response);
		} else {

			DB db = new DB();
			List<Item> items = db.getAllItems();
			request.setAttribute("items", items);
			request.getRequestDispatcher("WEB-INF/pages/ItemList.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
