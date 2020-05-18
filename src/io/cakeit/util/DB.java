package io.cakeit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.cakeit.entity.Article;
import io.cakeit.entity.Collect;
import io.cakeit.entity.Item;
import io.cakeit.entity.Menu;
import io.cakeit.entity.User;

public class DB {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/cakeit?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
	String user = "root";
	String psw = "zjh19990114";

	public DB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, psw);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean signUp(User user) {
		try {
			String sql = "insert into users(username,password,sex,phonenumber) values(?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getSex());
			pstmt.setString(4, user.getPhonenumber());
			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

	public User findUsername(String username) {
		String sql = "select * from users where username=?";
		User user = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next())
					user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
							rs.getString("sex"), rs.getString("phonenumber"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	

	public User login(String phonenumber, String password) {
		String sql = "select * from users where phonenumber=? and password=?";
		User user = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phonenumber);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs != null) {
				while (rs.next())
					user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
							rs.getString("sex"), rs.getString("phonenumber"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean releaseArticle(Article article) {
		try {
			String sql = "insert into article(title,content,releasetime) values(?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getContent());
			pstmt.setString(3, article.getReleasetime());
			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Article> getAllArticles() {
		ArrayList<Article> articles = new ArrayList<Article>();
		String sql = "select * from article";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				articles.add(new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			
			rs.close();
			con.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return articles;
	}

	public Article getArticleById(int id) {

		String sql = "select * from article where id=?";
		Article article = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				article = new Article(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return article;
	}
	
	public List<Item> getAllItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		String sql = "select * from item";
		try {
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				items.add(new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
							rs.getFloat(6), rs.getString(7)));
			}
			
			rs.close();
			con.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return items;
	}

	public Item getItemById(int id) {

		String sql = "select * from item where id=?";
		Item item = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				item = new Item(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),
						rs.getFloat(6), rs.getString(7));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return item;
	}
	
	public void updateItemAmount(Item item,float count) {
		String sql = "update item set amount =? where id =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1, item.getAmount() - count);
			pstmt.setInt(2, item.getId());
			pstmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Menu> getMenuList() {
		String sql = "select * from menu";
		List<Menu> menulist = new ArrayList<Menu>();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menulist.add(new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menulist;
	}

	public Menu getMenuById(int id) {

		String sql = "select * from menu where id=?";
		Menu menu = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menu = new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}
	public ArrayList<Menu> getMenuByIds(String[] ids) {

		String sql = "select * from menu where id=?";
		ArrayList<Menu> menu = new ArrayList<Menu>();

		try {
			pstmt = con.prepareStatement(sql);
			for(String id:ids) {
				pstmt.setInt(1, Integer.parseInt(id));
				rs = pstmt.executeQuery();
				while (rs.next()) {
					menu.add(new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getInt(8)));
	
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menu;
	}

	public void updateMenuViewTime(Menu menu) {
		String sql = "update menu set viewtimes=? where id=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menu.getViewtimes() + 1);
			pstmt.setInt(2, menu.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Menu> getMenuByTitle(String title) {
		String sql = "select * from menu where title like ?";
		List<Menu> menulist = new ArrayList<Menu>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs=pstmt.executeQuery();
			while (rs.next()) {
				menulist.add(new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menulist;
	}
	
	public List<Menu> bestMenu() {
		String sql="select * from menu order by viewtimes desc limit 3";
		List<Menu> menulist = new ArrayList<Menu>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menulist.add(new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menulist;
	}
	
	public void addCollectMenu(int menuid,int userid) {
		try {
			String sql = "insert into collect(menuid,userid) values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,menuid);
			pstmt.setInt(2,userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Collect> getCollectMenu(int userid) {
		String sql = "select * from collect where userid=?";
		List<Collect> menulist = new ArrayList<Collect>();
		try {
			pstmt = con.prepareStatement(sql);	
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menulist.add(new Collect(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menulist;
	}
	
	public boolean deleteCollectMenu(int menuid,int userid) {
		try {
			String sql = "delete from collect where menuid=? and userid=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,menuid);
			pstmt.setInt(2,userid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean UploadMenu(Menu menu) {
		try {
			String sql = "insert into menu(userid,title,material,step,level,img) values(?,?,?,?,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menu.getUserid());
			pstmt.setString(2, menu.getTitle());
			pstmt.setString(3,menu.getMaterial());
			pstmt.setString(4, menu.getStep());
			pstmt.setString(5, menu.getLevel());
			pstmt.setString(6, menu.getImg());
			int result = pstmt.executeUpdate();
			if (result != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Menu> getMyMenuList(int userid) {
		String sql = "select * from menu where userid=?";
		List<Menu> menulist = new ArrayList<Menu>();
		try {
			pstmt = con.prepareStatement(sql);	
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				menulist.add(new Menu(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getInt(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menulist;
	}
	
	public boolean deleteMenu(Menu menu) {
		try {
			String sql = "delete from menu where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, menu.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
