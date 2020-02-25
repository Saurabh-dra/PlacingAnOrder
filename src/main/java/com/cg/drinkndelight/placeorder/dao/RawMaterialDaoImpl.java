package com.cg.drinkndelight.placeorder.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.cg.drinkndelight.placeorder.beans.RawMaterial;

public class RawMaterialDaoImpl implements RawMaterialDao {

	public static final Map<String, RawMaterial> rawList = new HashMap<>();
	private static final int RANGE = 10000;

	@Override
	public void addRawMAtertial(RawMaterial rm) {
		Random rand = new Random();
		String orderID = "RM" + rand.nextInt(RANGE);
		rawList.put(orderID, rm);
	}

	@Override
	public Map<String, RawMaterial> displayRawMaterialList() {

		return rawList;

	}

}
