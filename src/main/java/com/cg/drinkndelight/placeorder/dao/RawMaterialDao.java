package com.cg.drinkndelight.placeorder.dao;

import java.util.Map;

import com.cg.drinkndelight.placeorder.beans.RawMaterial;

public interface RawMaterialDao {
	void addRawMAtertial(RawMaterial rm);

	Map<String, RawMaterial> displayRawMaterialList();

}
