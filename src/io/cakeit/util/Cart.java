package io.cakeit.util;

import java.util.ArrayList;
import io.cakeit.entity.Item;

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
