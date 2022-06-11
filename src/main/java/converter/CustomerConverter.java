package converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import service.CustomerService;
import entities.Customers;

public class CustomerConverter implements Converter<String, Customers> {

	@Autowired
	CustomerService customerService;

	public Customers convert(String id) {
		return customerService.find(Integer.parseInt(id));
	}

}
