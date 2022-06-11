package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import service.MechanicService;
import entities.Mechanic;

public class MechanicConverter implements Converter<String, Mechanic> {

	@Autowired
	MechanicService mechanicService;

	public Mechanic convert(String id) {
		return mechanicService.find(Integer.parseInt(id));
	}

}
