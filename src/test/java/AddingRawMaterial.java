import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.cg.drinkndelight.placeorder.beans.RawMaterial;
import com.cg.drinkndelight.placeorder.dao.RawMaterialDaoImpl;

class AddingRawMaterial {

	@Test
	void test() {
		RawMaterialDaoImpl rObj=new RawMaterialDaoImpl();
		String sdate="20/03/2020";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate exitdate = null;
		exitdate = LocalDate.parse(sdate, formatter);
		RawMaterial rw= new RawMaterial("Lemon","Supplier101","Warehouse101",5,10,exitdate);
		
		
	}

}
