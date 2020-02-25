package com.cg.drinkndelight.placeorder.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.cg.drinkndelight.placeorder.beans.Product;

public class ProductDaoImpl implements ProductDao {

	public static final Map<String, Product> productList = new HashMap<>();
	private static final int RANGE = 10000;

	@Override
	public void addProductList(Product product) {
		Random rand = new Random();
		String orderID = "P" + rand.nextInt(RANGE);
		productList.put(orderID, product);
	}

	@Override
	public Map<String, Product> displayOrderList() {
		return productList;
	}

}
