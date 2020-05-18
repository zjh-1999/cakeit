package io.cakeit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Cart;
import io.cakeit.entity.Item;
import io.cakeit.util.DB;

@WebServlet("/OrderForm")
public class OrderFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OrderFormServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Cart cart=(Cart)session.getAttribute("cart");
		ArrayList<Item> items = cart.getItem();
		for (Item item : items) {
			float count=item.getCount();
			new DB().updateItemAmount(item, count);
		}
		
		session.setAttribute("cart", cart);
		request.getRequestDispatcher("WEB-INF/pages/orderForm.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		doGet(request, response);
	}

}
