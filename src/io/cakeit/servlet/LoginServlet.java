package io.cakeit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.User;
import io.cakeit.util.DB;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String phonenumber = request.getParameter("phonenumber");
		HttpSession session = request.getSession();
		String password = request.getParameter("password");
		DB db = new DB();
		User user = db.login(phonenumber, password);
		if (user == null) {
			session.setAttribute("loginmsg", "login failed");
		} else {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("islogin", "okay"); 
			session.setAttribute("user", user);
			session.setAttribute("loginmsg", "login okay");
		}

		request.getRequestDispatcher("WEB-INF/pages/loginOkay.jsp").forward(request, response);
	}

}
