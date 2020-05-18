package io.cakeit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Menu;
import io.cakeit.util.DB;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HistoryServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ArrayList<Menu> history = (ArrayList<Menu>) session.getAttribute("history");
		String str = "";
		ArrayList<Menu> historyMenu=null;
		if (history != null) {
			for (Menu menu : history) {
				str = str + menu.getId() + "-";
			}
			Cookie c = new Cookie("history", str);
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c);
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie a : cookies) {
					if (a.getName().equals("history")) {
						str = a.getValue();
					}
				}
			}
			String[] ids = str.split("-");
			DB db = new DB();
			historyMenu = db.getMenuByIds(ids);
		}
		request.setAttribute("history", historyMenu);
		request.getRequestDispatcher("WEB-INF/pages/history.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
