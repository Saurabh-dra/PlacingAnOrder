package com.cg.drinkndelight.placeorder.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;

import com.cg.drinkndelight.placeorder.services.RawMaterialServices;
import com.cg.drinkndelight.placeorder.util.ProductMenu;
import com.cg.drinkndelight.placeorder.util.RawMaterialMenu;
import com.cg.drinkndelight.placeorder.services.ProductServices;
import com.cg.drinkndelight.placeorder.beans.Product;
import com.cg.drinkndelight.placeorder.beans.RawMaterial;
import com.cg.drinkndelight.placeorder.exception.InvalidInputException;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	RawMaterialServices rawmaterialservices = new RawMaterialServices();
	ProductServices productServices = new ProductServices();
	RawMaterialMenu rmMenu = new RawMaterialMenu();
	ProductMenu proMenu = new ProductMenu();

	public static void main(String[] args) throws IOException, InvalidInputException {
		Main obj = new Main();
		System.out.println("**** Welcome to Drink & Delight ****");

		System.out.println("**********************************************************");
		obj.selectSystem();
	}

	// method to chose to order raw material or product
	public void selectSystem() throws IOException, InvalidInputException {
		System.out.println("Select Your System:");
		int flag = 1;
		while (flag == 1) {
			System.out.println("1. Raw Material Manager\n2. Product Order Manager\n3. Terminate Operation");
			String choice = br.readLine();
			if (choice.isEmpty()) {
				System.out.println("Chpose Type of System\n");
				selectSystem();
			} else {
				switch (choice) {
				case "1":
					List<String> rawList;

					System.out.println("**********************************************************");
					System.out.println("\nRaw Material Menu");
					rawList = rmMenu.rawmaterialMenu();
					rawList.forEach((v) -> System.out.println(v));
					System.out.println("\nSupplier List");
					rawList = rmMenu.supplierMenu();
					rawList.forEach((v) -> System.out.println(v));
					System.out.println("\nWarehouse List");
					rawList = rmMenu.warehouseMenu();
					rawList.forEach((v) -> System.out.println(v));
					System.out.println();
					System.out.println("**********************************************************");
					selectRawMaterialOperation();
					break;
				case "2":
					List<String> proList;
					System.out.println("**********************************************************");
					System.out.println("\nProduct Menu");
					proList = proMenu.productMenu();
					proList.forEach((v) -> System.out.println(v));
					System.out.println();
					System.out.println("**********************************************************");
					selectProductOperation();
					break;
				case "3": // Termination
					flag = 0;
					break;
				default:
					System.out.println("\n *Wrong Choice* \n");
					break;
				}
			}
		}
	}

	// Raw Material Manager
	public void selectRawMaterialOperation() throws IOException, InvalidInputException {
		System.out.println("Select your Operation:");
		int flag = 1;
		while (flag == 1) {
			System.out.println("1. Place Raw Material Order\n2. Display Ordered Items\n3. Exit");
			String choice = br.readLine();
			if (choice.isEmpty()) {
				System.out.println("Please choose an Operation");
				selectRawMaterialOperation();
			} else {
				switch (choice) {
				// add item
				case "1":
					List<String> rawMenu;
					int quantity = 0;
					double pricePerUnit = 0;
					System.out.println("Enter Raw Material Name:");
					String rawName = br.readLine();
					rawMenu = rmMenu.rawmaterialMenu();
					if (rawName.isEmpty() || !rawMenu.contains(rawName)) {
						System.out.println("Raw Material name is empty or Material not found\n");
						selectRawMaterialOperation();
						continue;
					}
					System.out.println("Enter Supplier ID:");
					String supplierID = br.readLine();
					rawMenu = rmMenu.supplierMenu();
					if (supplierID.isEmpty() || !rawMenu.contains(supplierID)) {
						System.out.println("Choose a Supplier Please\n");
						selectRawMaterialOperation();
						continue;
					}
					System.out.println("Enter Warehouse ID:");
					String warehouseID = br.readLine();
					rawMenu = rmMenu.warehouseMenu();
					if (warehouseID.isEmpty() || !rawMenu.contains(warehouseID)) {
						System.out.println("Choose a Warehouse Please\n");
						selectRawMaterialOperation();
						continue;
					}
					System.out.println("Enter Quantity/Unit of Purchase:");
					try {
						quantity = Integer.parseInt(br.readLine());
					} catch (NumberFormatException e) {
						System.out.println("Quantity must be an Integer");
						selectRawMaterialOperation();
					}
					System.out.println("Enter Price per Unit:");
					try {
						pricePerUnit = Double.parseDouble(br.readLine());
					} catch (NumberFormatException e) {
						System.out.println(e.getMessage());
						selectRawMaterialOperation();
					}
					System.out.println("Enter Date of Delivery:");
					String sDate = br.readLine();
					LocalDate DateOfDelivery = null;
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						DateOfDelivery = LocalDate.parse(sDate, formatter);
					} catch (DateTimeParseException e) {
						System.out.println(e.getMessage());
						selectRawMaterialOperation();
						continue;
					}
					try {
						rawmaterialservices.addRawMaterial(new RawMaterial(rawName, supplierID, warehouseID, quantity,
								pricePerUnit, DateOfDelivery));
					} catch (InvalidInputException e) {
						System.out.println(e.getMessage());
						selectRawMaterialOperation();
						continue;
					}
					break;
				// display
				case "2":
					Map<String, RawMaterial> rawList = rawmaterialservices.displayRawMaterial();
					rawList.forEach((k, v) -> System.out.println(k + "\t" + v));
					break;
				// terminate
				case "3":
					flag = 0;
					break;
				default:
					System.out.println("\n *Wrong Choice* \n");
					break;
				}
			}
		}
	}

	// Product Order Manager
	public void selectProductOperation() throws IOException, InvalidInputException {
		System.out.println("Select your Operation:");
		int flag = 1;
		while (flag == 1) {
			System.out.println("1. Place Product Order\n2. Display Ordered Items\n3. Exit");
			String choice = br.readLine();
			if (choice.isEmpty()) {
				System.out.println("Please choose an operation");
				selectProductOperation();
			} else {
				switch (choice) {
				// add item
				case "1":
					System.out.println("Enter Product Name:");
					String productName = br.readLine();
					List<String> proList;
					proList = proMenu.productMenu();
					if (productName.isEmpty() || !proList.contains(productName)) {
						System.out.println("Product Name empty or product not found\n");
						selectProductOperation();
						continue;
					}
					System.out.println("Enter Quantity/Unit of Purchase:");
					int quantity = 0;
					try {
						quantity = Integer.parseInt(br.readLine());
					} catch (Exception e) {
						System.out.println("Quantity must be an Integer");
						selectProductOperation();
					}
					System.out.println("Enter Price per Unit:");
					double pricePerUnit = 0;
					try {
						pricePerUnit = Double.parseDouble(br.readLine());
					} catch (Exception e) {
						System.out.println("Enter a valid amount");
						selectProductOperation();
					}
					System.out.println("Enter Date of Delivery:");
					String sDate = br.readLine();
					LocalDate ExitDate = null;
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					try {
						ExitDate = LocalDate.parse(sDate, formatter);
					} catch (DateTimeParseException e) {
						System.out.println("Enter date in dd/mm/yyyy format only");
						selectProductOperation();
						continue;
					}
					try {
						productServices.addProduct(new Product(productName, pricePerUnit, quantity, ExitDate));
					} catch (InvalidInputException e) {
						System.out.println(e.getMessage());
						selectProductOperation();
						continue;
					}
					break;
				case "2": // display
					Map<String, Product> pList = productServices.displayProduct();
					pList.forEach((k, v) -> System.out.println(k + "\t" + v));
					break;
				// terminate
				case "3":
					flag = 0;
					break;
				default:
					System.out.println("\n *Wrong Choice* \n");
					break;
				}
			}
		}
	}
}
