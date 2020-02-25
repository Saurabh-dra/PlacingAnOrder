package com.cg.drinkndelight.placeorder.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.cg.drinkndelight.placeorder.services.RawMaterialServices;
import com.cg.drinkndelight.placeorder.services.ProductServices;
import com.cg.drinkndelight.placeorder.beans.Product;
import com.cg.drinkndelight.placeorder.beans.RawMaterial;
import com.cg.drinkndelight.placeorder.exception.InvalidInputExpection;

public class Main {
	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private RawMaterialServices rawmaterialservices = new RawMaterialServices();
	private ProductServices productServices = new ProductServices();

	public static void main(String[] args) {
		Main obj = new Main();
		System.out.println("**** Welcome to Drink & Delight ****");
		try {
			obj.selectSystem();
		} catch (IOException | InvalidInputExpection e) {
			e.printStackTrace();
		}
	}

	// method to chose to order raw material or product
	public void selectSystem() throws IOException, InvalidInputExpection {
		System.out.println("Select Your System:");
		int flag = 1;
		while (flag == 1) {
			System.out.println("1. Raw Material Manager\n2. Product Order Manager\n3. Terminate Operation");
			int choice = 0;
			try {
				choice = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			switch (choice) {
			// Raw Material Manager
			case 1:
				selectRawMaterialOperation();
				break;
			// Product Order Manager
			case 2:
				selectProductOperation();
				break;
			// Termination
			case 3:
				flag = 0;
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public void selectRawMaterialOperation() throws IOException, InvalidInputExpection {
		System.out.println("Select your Operation:");
		int flag = 1;
		while (flag == 1) {
			System.out.println(
					"1. Place Raw Material Order\n2. Display Ordered Items\n3. Raw Material Menu\n4. Terminate");
			int choice = Integer.parseInt(br.readLine());
			switch (choice) {
			// add item
			case 1:
				System.out.println("Enter Raw Material Name:");
				String rawName = br.readLine();
				System.out.println("Enter Supplier ID:");
				String supplierID = br.readLine();
				System.out.println("Enter Warehouse ID:");
				String warehouseID = br.readLine();
				System.out.println("Enter Quantity/Unit of Purchase:");
				int quantity = Integer.parseInt(br.readLine());
				System.out.println("Enter Price per Unit:");
				double pricePerUnit = Double.parseDouble(br.readLine());
				System.out.println("Enter Date of Delivery:");
				String sDate = br.readLine();
				LocalDate DateOfDelivery = null;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				DateOfDelivery = LocalDate.parse(sDate, formatter);
				rawmaterialservices.addRawMaterial(
						new RawMaterial(rawName, supplierID, warehouseID, quantity, pricePerUnit, DateOfDelivery));
				break;
			// display
			case 2:
				Map<String, RawMaterial> rawList = rawmaterialservices.displayRawMaterial();
				rawList.forEach((k, v) -> System.out.println(k + "\t" + v));
				break;
			// terminate
			case 3:
				flag = 0;
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}

	public void selectProductOperation() throws IOException, InvalidInputExpection {
		System.out.println("Select your Operation:");
		int flag = 1;
		while (flag == 1) {
			System.out.println("1. Place Product Order\n2. Display Ordered Items\n3. Product Menu\n4. Terminate");
			int choice1 = 0;
			try {
				choice1 = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				e.printStackTrace();
			}
			switch (choice1) {
			// add item
			case 1:
				System.out.println("Enter Product Name:");
				String productName = br.readLine();
				System.out.println("Enter Quantity/Unit of Purchase:");
				int quantity = Integer.parseInt(br.readLine());
				System.out.println("Enter Price per Unit:");
				double pricePerUnit = Double.parseDouble(br.readLine());
				System.out.println("Enter Date of Delivery:");
				String sdate = br.readLine();
				LocalDate exitdate = null;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				exitdate = LocalDate.parse(sdate, formatter);
				productServices.addProduct(new Product(productName, pricePerUnit, quantity, exitdate));
				break;
			// display
			case 2:
				Map<String, Product> pList = productServices.displayProduct();
				pList.forEach((k, v) -> System.out.println(k + "\t" + v));
				break;
			// Terminate
			case 3:
				flag = 0;
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		}
	}
}
