package io.cakeit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import io.cakeit.entity.Article;
import io.cakeit.util.DB;

@WebServlet("/Community")
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommunityServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("islogin") == null) {
			request.getRequestDispatcher("WEB-INF/pages/noSignUp.jsp").forward(request, response);
		} else {
			DB db = new DB();
			List<Article> articles = db.getAllArticles();
			request.setAttribute("articles", articles);
			request.getRequestDispatcher("WEB-INF/pages/community.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String releasetime = request.getParameter("releasetime");

		DB db = new DB();
		Article article = new Article(title, content, releasetime);

		boolean a = db.releaseArticle(article);
		if (a == true) {
			request.setAttribute("releasemsg", "�ɹ���");
		} else {
			request.setAttribute("releasemsg", "ʧ��");
		}
		request.getRequestDispatcher("WEB-INF/pages/releaseArticle.jsp").forward(request, response);
	}

}
