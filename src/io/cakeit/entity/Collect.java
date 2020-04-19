package io.cakeit.entity;

public class Collect {
	private int collectid;
	private int menuid;
	private int userid;
	
	
	public Collect(int collectid, int menuid, int userid) {
		super();
		this.collectid = collectid;
		this.menuid = menuid;
		this.userid = userid;
	}
	
	public Collect(int menuid, int userid) {
		super();
		this.menuid = menuid;
		this.userid = userid;
	}

	public int getCollectid() {
		return collectid;
	}
	public void setCollectid(int collectid) {
		this.collectid = collectid;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
