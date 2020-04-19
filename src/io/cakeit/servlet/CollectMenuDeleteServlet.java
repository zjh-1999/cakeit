package io.cakeit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Menu;
import io.cakeit.entity.User;
import io.cakeit.util.DB;

@WebServlet("/collectMenuDelete")
public class CollectMenuDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CollectMenuDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db=new DB();
		Menu menu = db.getMenuById(Integer.parseInt(request.getParameter("id")));
		int menuid=menu.getId();
		HttpSession session = request.getSession();
		User user=null;
		user=(User) session.getAttribute("user");
		int userid=user.getId();
		db.deleteCollectMenu(menuid, userid);
		request.getRequestDispatcher("WEB-INF/pages/menuOkay.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
