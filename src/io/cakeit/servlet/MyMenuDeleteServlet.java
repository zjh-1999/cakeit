package io.cakeit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.cakeit.entity.Menu;
import io.cakeit.util.DB;

@WebServlet("/myMenuDelete")
public class MyMenuDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyMenuDeleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB db=new DB();
		Menu menu = db.getMenuById(Integer.parseInt(request.getParameter("id")));
		db.deleteMenu(menu);
		request.getRequestDispatcher("WEB-INF/pages/menuOkay.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
