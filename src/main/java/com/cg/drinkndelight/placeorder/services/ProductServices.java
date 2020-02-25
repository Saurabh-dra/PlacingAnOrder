package com.cg.drinkndelight.placeorder.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.cg.drinkndelight.placeorder.beans.Product;
import com.cg.drinkndelight.placeorder.dao.ProductDao;
import com.cg.drinkndelight.placeorder.dao.ProductDaoImpl;
import com.cg.drinkndelight.placeorder.exception.InvalidInputExpection;

public class ProductServices {
	private ProductDao productDao;

	public ProductServices() {
		productDao = new ProductDaoImpl();
	}

	/// adding the products one by one
	public void addProduct(Product product) throws InvalidInputExpection {
		LocalDate now = LocalDate.now();
		Period diff = Period.between(now, product.geExitDate());
		if (diff.getMonths() > 2 || product.geExitDate().isBefore(now)) {
			throw new InvalidInputExpection("Date is out of Bound");
		} else {
			productDao.addProductList(product);
		}
	}

	// display the Product that is ordered
	public Map<String, Product> displayProduct() {
		return productDao.displayOrderList();
	}
}
