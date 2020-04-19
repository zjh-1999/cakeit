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

@WebServlet("/collect")
public class CollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CollectServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("islogin")==null) {
			request.getRequestDispatcher("WEB-INF/pages/noSignUp.jsp").forward(request, response);
		}
		else {
			User user=(User)session.getAttribute("user");
			Menu menu=(Menu)session.getAttribute("menu");
			DB db=new DB();
			db.addCollectMenu(menu.getId(),user.getId());
			request.getRequestDispatcher("WEB-INF/pages/collectOkay.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
