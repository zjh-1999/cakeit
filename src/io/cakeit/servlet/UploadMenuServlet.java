package io.cakeit.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
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

		RequestContext requestContext = new ServletRequestContext(request);


		if (FileUpload.isMultipartContent(requestContext)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置文件的缓存路径
			factory.setRepository(new File("c:/tmp/"));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(100 * 1024 * 1024);
			List items = new ArrayList();
			try {
				// 上传文件，并解析出所有的表单字段，包括普通字段和文件字段
				items = upload.parseRequest(request);
			} catch (FileUploadException e1) {
				System.out.println("文件上传发生错误" + e1.getMessage());
			}
			// 下面对每个字段进行处理，分普通字段和文件字段
			Iterator it = items.iterator();
			while (it.hasNext()) {
				FileItem fileItem = (FileItem) it.next();
				// 如果是普通字段
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + " " + fileItem.getName() + " "
							+ new String(fileItem.getString().getBytes("utf-8"), "utf-8"));
				} else {
					System.out.println(fileItem.getFieldName() + " " +
							fileItem.getName() + " " +
							fileItem.isInMemory() + " " +
							fileItem.getContentType() + " " +
							fileItem.getSize());
					// 保存文件，其实就是把缓存里的数据写到目标路径下
					if (fileItem.getName() != null && fileItem.getSize() != 0) {
						File fullFile = new File(fileItem.getName());
						File newFile = new File("c:/temp/" + fullFile.getName());
						try {
							fileItem.write(newFile);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						System.out.println("文件没有选择 或 文件内容为空");

					}

				}

			}

		}

	}

}
