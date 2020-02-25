package com.cg.drinkndelight.placeorder.beans;

import java.time.LocalDate;

public class Product {

	private String ProductName;
	private String SupplierID;
	private String WarehouseID;
	private String OrderID;
	private double PricePerUnit;
	private int Quantity;
	LocalDate ExitDate;

	public Product(String productName, double pricePerUnit, int quantity, LocalDate exitDate) {
		super();
		ProductName = productName;
		PricePerUnit = pricePerUnit;
		Quantity = quantity;
		ExitDate = exitDate;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public String getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}

	public String getWarehouseID() {
		return WarehouseID;
	}

	public void setWarehouseID(String warehouseID) {
		WarehouseID = warehouseID;
	}

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		OrderID = orderID;
	}

	public double getPricePerUnit() {
		return PricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		PricePerUnit = pricePerUnit;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public LocalDate geExitDate() {
		return ExitDate;
	}

	public void setExitDate(LocalDate exitDate) {
		ExitDate = exitDate;
	}

}
