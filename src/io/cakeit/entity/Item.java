package io.cakeit.entity;

public class Item {
	
	private int id;
	private String itemname;
	private String brand;
	private String quality;
	private float amount;
	private float price;
	private String icon;
	private float count;
	private float sum;
	
	
	public Item() {
		super();
	}
	
	
	
	public Item(String itemname, String brand, String quality, float amount, float price, String icon, float count) {
		super();
		this.itemname = itemname;
		this.brand = brand;
		this.quality = quality;
		this.amount = amount;
		this.price = price;
		this.icon = icon;
		this.count = count;
	}



	public Item(int id, String itemname, String brand, String quality, float amount, float price, String icon) {
		super();
		this.id = id;
		this.itemname = itemname;
		this.brand = brand;
		this.quality = quality;
		this.amount = amount;
		this.price = price;
		this.icon = icon;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
	public float getCount() {
		return count;
	}
	public void setCount(float count) {
		this.count = count;
	}
	public float getSum() {
		

		sum=price*count;
		return sum;
	}


	

}
