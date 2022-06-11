package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CustomerService;
import entities.Customers;

@Controller
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@ModelAttribute("customer")
	public Customers getCustomer() {
		Customers c = new Customers();
		c.setGender("Male");
		return c;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "vehicle_customer_add";
	}

	@RequestMapping(value = "/handleAdd", method = RequestMethod.POST)
	public String handleAdd(
			@ModelAttribute("customer") @Valid Customers customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "vehicle_customer_add";
		}
		customerService.create(customer);
		return "redirect:display";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String dispay(ModelMap mm) {
		mm.put("customers", customerService.findAll());
		return "vehicle_customer_display";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, ModelMap mm) {
		try {
			customerService.delete(customerService.find(id));
		} catch (Exception e) {
			mm.put("message","Can not delete!" );
		}
		mm.put("customers", customerService.findAll());
		return "vehicle_customer_display";
	}

	@RequestMapping(value = "/update/{id}")
	public String update(@PathVariable("id") int id, ModelMap mm) {
		mm.put("customer", customerService.find(id));
		return "vehicle_customer_update";
	}

	@RequestMapping(value = "/handleUpdate")
	public String handleUpdate(
			@ModelAttribute("customer") @Valid Customers customer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "vehicle_customer_update";
		}
		customerService.update(customer);
		return "redirect:display";
	}
}
