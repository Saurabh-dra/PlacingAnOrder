package com.cg.drinkndelight.placeorder.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.cg.drinkndelight.placeorder.beans.RawMaterial;
import com.cg.drinkndelight.placeorder.dao.RawMaterialDao;
import com.cg.drinkndelight.placeorder.dao.RawMaterialDaoImpl;
import com.cg.drinkndelight.placeorder.exception.InvalidInputException;

public class RawMaterialServices {
	private RawMaterialDao rawmaterialDao;

	public RawMaterialServices() {
		rawmaterialDao = new RawMaterialDaoImpl();
	}

	// adding the raw material one by one
	public void addRawMaterial(RawMaterial rawMaterial) throws InvalidInputException {
		LocalDate now = LocalDate.now();
		Period diff = Period.between(now, rawMaterial.getDateOfDelivery());
		if (diff.getMonths() > 2 || rawMaterial.getDateOfDelivery().isBefore(now)) {
			throw new InvalidInputException("Date is out of Bound");
		} else {
			rawmaterialDao.addRawMAtertial(rawMaterial);
		}
	}

	// display the Raw Material Order List
	public Map<String, RawMaterial> displayRawMaterial() {
		return rawmaterialDao.displayRawMaterialList();
	}
}
