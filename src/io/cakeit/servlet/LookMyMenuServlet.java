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
import io.cakeit.entity.User;
import io.cakeit.util.DB;

@WebServlet("/lookMyMenu")
public class LookMyMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LookMyMenuServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db = new DB();
		HttpSession session = request.getSession();
		User user=null;
		user=(User) session.getAttribute("user");
		int userid=user.getId();
		List<Menu> menulist = db.getMyMenuList(userid);
		request.setAttribute("mymenulist", menulist);
		request.getRequestDispatcher("WEB-INF/pages/lookMyMenu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
