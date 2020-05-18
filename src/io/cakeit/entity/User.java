package io.cakeit.entity;

public class User {
	private int id;
	private String username;
	private String password;
	private String sex;
	private String phonenumber;

	public User(String username, String password, String sex, String phonenumber) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phonenumber = phonenumber;
	}

	public User(int id, String username, String password, String sex, String phonenumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.phonenumber = phonenumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

}
