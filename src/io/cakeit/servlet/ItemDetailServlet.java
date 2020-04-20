package io.cakeit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Item;
import io.cakeit.util.DB;

@WebServlet("/ItemDetail")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ItemDetailServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		DB db=new DB();
		Item item=db.getItemById(Integer.parseInt(request.getParameter("id")));

		//session.getAttribute("user");
		request.setAttribute("item", item);
		session.setAttribute("itemOnView", item);
		request.getRequestDispatcher("WEB-INF/pages/ItemDetail.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
