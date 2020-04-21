package io.cakeit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.cakeit.entity.Article;
import io.cakeit.util.DB;


@WebServlet("/Community")
public class CommunityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CommunityServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DB db = new DB();
		List<Article> articles = db.getAllArticles();
		request.setAttribute("articles", articles);
		request.getRequestDispatcher("WEB-INF/pages/Community.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		String releasetime=request.getParameter("releasetime");
		
		Article article=new Article(title,content,releasetime);
		DB db=new DB();
		boolean a=db.releaseArticle(article);
		if(a==true) {
			request.setAttribute("signupmsg", "³É¹¦");
		}
		else {
			request.setAttribute("signupmsg", "Ê§°Ü");
		}
		request.getRequestDispatcher("WEB-INF/pages/releaseArticle.jsp").forward(request,response);
	}

}
