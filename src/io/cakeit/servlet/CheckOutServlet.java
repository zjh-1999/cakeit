package io.cakeit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import io.cakeit.entity.Item;
import io.cakeit.util.Cart;
import io.cakeit.util.DB;

@WebServlet("/CheckOut")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckOutServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.getRequestDispatcher("WEB-INF/pages/CheckOut.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		
		doGet(request, response);
	}

}
