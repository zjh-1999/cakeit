package io.cakeit.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import io.cakeit.entity.Menu;
import io.cakeit.entity.User;
import io.cakeit.util.DB;

@WebServlet("/uploadMenu")
public class UploadMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadMenuServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = null;
		user = (User) session.getAttribute("user");
		int userid = user.getId();

		String title = request.getParameter("title");
		String material = request.getParameter("material");
		String step = request.getParameter("step");
		String level = request.getParameter("level");
		String img = request.getParameter("img");
		Boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (!isMultipart) {
			return; // 如果不是就不用上传了
		}

		try {

			// 创建FileItemFactory对象
			FileItemFactory factory = new DiskFileItemFactory();
			// 创建文件上传的处理器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析请求
			List<FileItem> items = upload.parseRequest(request);
			// 迭代出每一个FileItem
			for (FileItem item : items) {
				String fileName = item.getFieldName();
				if (item.isFormField()) {
					// 普通的表单控件
					String value = item.getString("utf-8");
					System.out.println(fileName + "->" + value);
				} else {
					// 上传文件的控件
					String RandomName = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(item.getName());
					System.out.println(fileName + "->" + FilenameUtils.getName(item.getName())); // 一个的标签的name，一个是文件的name
					String path = super.getServletContext().getRealPath("/upload");
					System.out.println(path);
					item.write(new File(path, RandomName)); // 把上传的文件保存到某个文件中
				}
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}

		DB db = new DB();
		Menu menu = new Menu(userid, title, material, step, level, img);
		boolean a = db.UploadMenu(menu);
		if (a == true) {
			request.getRequestDispatcher("WEB-INF/pages/menuOkay.jsp").forward(request, response);
		}
	}
}
