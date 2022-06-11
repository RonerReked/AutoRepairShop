package controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CustomerService;
import service.VehicleService;
import entities.Customers;
import entities.Vehicles;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;
	@Autowired
	CustomerService customerService;

	@ModelAttribute("customers")
	public List<Customers> getCustomers() {
		return customerService.findAll();
	}

	@ModelAttribute("vehicle")
	public Vehicles getVehicle() {
		return new Vehicles();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap mm) {
		return "vehicle_vehicle_add";
	}

	@RequestMapping(value = "/handleAdd", method = RequestMethod.POST)
	public String handleAdd(@RequestParam("customerid") int id,
			@ModelAttribute("vehicle") @Valid Vehicles vehicle,
			BindingResult result) {
		if (result.hasErrors()) {
			return "vehicle_vehicle_add";
		}
		System.out.println(id);
		Set<Customers> listCustomers = new HashSet<Customers>(0);
		listCustomers.add(customerService.find(id));
		vehicle.setCustomerses(listCustomers);
		vehicleService.create(vehicle);
		return "redirect:display";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String dispay(ModelMap mm) {
		mm.put("vehicles", vehicleService.findAll());
		return "vehicle_vehicle_display";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, ModelMap mm) {
		try {
			vehicleService.delete(vehicleService.find(id));
		} catch (Exception e) {
			mm.put("message", "Can not delete");
		}
		mm.put("vehicles", vehicleService.findAll());
		return "vehicle_vehicle_display";
	}

	@RequestMapping(value = "/update/{id}")
	public String update(@PathVariable("id") int id, ModelMap mm) {
		mm.put("customers", customerService.findAll());
		mm.put("vehicle", vehicleService.find(id));
		return "vehicle_vehicle_update";
	}

	@RequestMapping(value = "/handleUpdate")
	public String handleUpdate(@RequestParam("customerid") int id,
			@ModelAttribute("vehicle") @Valid Vehicles vehicle,
			BindingResult result) {
		if (result.hasErrors()) {
			return "vehicle_vehicle_update";
		}
		Set<Customers> listCustomers = new HashSet<Customers>(0);
		listCustomers.add(customerService.find(id));
		vehicle.setCustomerses(listCustomers);
		vehicleService.update(vehicle);
		return "redirect:display";
	}
}
