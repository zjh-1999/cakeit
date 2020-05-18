package io.cakeit.entity;

import java.util.ArrayList;

public class Cart {

	private ArrayList<Item> box;

	public Cart() {
		box = new ArrayList<Item>();
	}
	public ArrayList<Item> getItem() {
		return box;
	}

	public void addItem(Item item) {
		box.add(item);
	}
	
}
