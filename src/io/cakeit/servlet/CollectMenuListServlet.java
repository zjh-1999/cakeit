package io.cakeit.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Collect;
import io.cakeit.entity.Menu;
import io.cakeit.entity.User;
import io.cakeit.util.DB;

@WebServlet("/collectMenuList")
public class CollectMenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CollectMenuListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db = new DB();
		HttpSession session = request.getSession();
		User user=null;
		user=(User) session.getAttribute("user");
		int userid=user.getId();
		List<Collect> menulist = db.getCollectMenu(userid);
		List<Menu> menu=new ArrayList<Menu>();
		for(Collect collect:menulist) {
			menu.add(db.getMenuById(collect.getMenuid()));
		}
		request.setAttribute("collectmenulist", menu);
		request.getRequestDispatcher("WEB-INF/pages/collectMenuList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
