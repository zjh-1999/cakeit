package io.cakeit.entity;

public class Menu {
	private int id;
	private int userid;
	private String title;
	private String material;
	private String step;
	private String level;
	private String img;
	private int viewtimes;

	public Menu(int userid, String title, String material, String step, String level, String img) {
		super();
		this.userid = userid;
		this.title = title;
		this.material = material;
		this.step = step;
		this.level = level;
		this.img = img;
	}

	public Menu(int id, int userid, String title, String material, String step, String level, String img,
			int viewtimes) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.material = material;
		this.step = step;
		this.level = level;
		this.img = img;
		this.viewtimes = viewtimes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getViewtimes() {
		return viewtimes;
	}

	public void setViewtimes(int viewtimes) {
		this.viewtimes = viewtimes;
	}
}
