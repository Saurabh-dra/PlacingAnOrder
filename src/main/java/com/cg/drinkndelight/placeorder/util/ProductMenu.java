package com.cg.drinkndelight.placeorder.util;

import java.util.ArrayList;
import java.util.List;

public class ProductMenu {
	public static final List<String> proList = new ArrayList<>();

	public List<String> productMenu() {

		proList.add("Lemonade");
		proList.add("Orange-Juice");
		proList.add("Lemon-Soda");
		proList.add("Orange-Soda");
		return proList;
	}
}
