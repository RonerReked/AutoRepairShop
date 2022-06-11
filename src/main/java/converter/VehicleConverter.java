package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import service.VehicleService;
import entities.Vehicles;

public class VehicleConverter implements Converter<String, Vehicles> {

	@Autowired
	VehicleService vehicleService;

	public Vehicles convert(String id) {
		return vehicleService.find(Integer.parseInt(id));
	}

}
