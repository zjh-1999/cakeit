package io.cakeit.entity;

public class Article {
	private int id;
	private String title;
	private String content;
	private String releasetime;
	
	
	public Article(int id, String title, String content, String releasetime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.releasetime = releasetime;
	}
	
	public Article(String title, String content, String releasetime) {
		super();
		this.title = title;
		this.content = content;
		this.releasetime = releasetime;
	}
	
	public Article() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}

}
