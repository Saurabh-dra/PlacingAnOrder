package com.cg.drinkndelight.placeorder.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.drinkndelight.placeorder.beans.Product;

public interface ProductDao 
{

	HashMap<String, Product> addProductList(Product product);

	Map<String, Product> displayOrderList();
}
