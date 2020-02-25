package com.cg.drinkndelight.placeorder.dao;

import java.util.Map;

import com.cg.drinkndelight.placeorder.beans.Product;

public interface ProductDao 
{

	void addProductList(Product product);

	Map<String, Product> displayOrderList();
}
