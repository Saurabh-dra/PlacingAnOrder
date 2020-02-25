package com.cg.drinkndelight.placeorder.util;

import java.util.ArrayList;
import java.util.List;

public class RawMaterialMenu {

	public static final List<String> rawList = new ArrayList<>();
	public static final List<String> supList = new ArrayList<>();
	public static final List<String> whList = new ArrayList<>();

	public List<String> rawmaterialMenu() {

		rawList.add("Lemon");
		rawList.add("Orange");
		rawList.add("Soda");
		return rawList;
	}

	public List<String> supplierMenu() {

		supList.add("S1010");
		supList.add("S1020");
		supList.add("S1030");
		return supList;
	}

	public List<String> warehouseMenu() {

		whList.add("W010");
		whList.add("W020");
		whList.add("W030");
		return whList;
	}
}
