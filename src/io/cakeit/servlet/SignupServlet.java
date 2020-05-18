package io.cakeit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.cakeit.entity.User;
import io.cakeit.util.DB;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String number=request.getParameter("phonenumber");
		User user = new User(username, password, gender, number);
		DB db = new DB();
		boolean a = db.signUp(user);
		if (a == true) {
			request.setAttribute("signupmsg", "注册成功");
		} else {
			request.setAttribute("signupmsg", "注册失败");
		}
		request.getRequestDispatcher("WEB-INF/pages/signupOkay.jsp").forward(request, response);
	}

}
