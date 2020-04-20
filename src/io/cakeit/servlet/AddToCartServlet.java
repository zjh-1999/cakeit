package io.cakeit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Item;
import io.cakeit.util.Cart;

@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddToCartServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		float count = Float.parseFloat(request.getParameter("count"));
		
		HttpSession session = request.getSession();
		
		Item item = (Item)session.getAttribute("itemOnView");
		item.setCount(count);
		
		Cart cart=null;
		if(session.getAttribute("cart")==null) {
			cart = new Cart();
		}else {
			cart = (Cart)session.getAttribute("cart");
		}
		cart.addItem(item);
		
		session.setAttribute("cart", cart);
		
		request.getRequestDispatcher("WEB-INF/pages/AddToCart.jsp").forward(request, response);
	}

}