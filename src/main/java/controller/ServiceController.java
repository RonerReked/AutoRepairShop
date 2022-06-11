package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CustomerService;
import service.MechanicService;
import service.ServiceService;
import service.VehicleService;
import entities.Customers;
import entities.Mechanic;
import entities.Services;
import entities.Vehicles;

@Controller
@RequestMapping("/services")
public class ServiceController {

	@Autowired
	ServiceService serviceService;
	@Autowired
	MechanicService mechanicService;
	@Autowired
	CustomerService customerService;
	@Autowired
	VehicleService vehicleService;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		simpleDateFormat.setLenient(false);
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
				simpleDateFormat, true));
	}

	@ModelAttribute("service")
	public Services getService() {
		return new Services();
	}

	@ModelAttribute("mechanics")
	public List<Mechanic> getMechanics() {
		return mechanicService.findAll();
	}

	@ModelAttribute("customers")
	public List<Customers> getCustomers() {
		return customerService.findAll();
	}

	@ModelAttribute("vehicles")
	public List<Vehicles> getVehicles() {
		return vehicleService.findAll();
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "vehicle_service_add";
	}

	@RequestMapping(value = "/handleAdd", method = RequestMethod.POST)
	public String handleAdd(@ModelAttribute("service") @Valid Services service,
			BindingResult result) {
		if (result.hasErrors()) {
			return "vehicle_service_add";
		}
		serviceService.create(service);
		return "redirect:display";
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public String dispay(ModelMap mm) {
		mm.put("services", serviceService.findAll());
		return "vehicle_service_display";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, ModelMap mm) {
		try {
			serviceService.delete(serviceService.find(id));
		} catch (Exception e) {
			mm.put("message", "Can not delete");
		}
		mm.put("services", serviceService.findAll());
		return "vehicle_service_display";
	}

	@RequestMapping(value = "/update/{id}")
	public String update(@PathVariable("id") int id, ModelMap mm) {
		Services s = serviceService.find(id);
		s.setMechanic(null);
		s.setCustomers(null);
		s.setVehicles(null);
		mm.put("service", s);
		return "vehicle_service_update";
	}

	@RequestMapping(value = "/handleUpdate")
	public String handleUpdate(
			@ModelAttribute("service") @Valid Services service,
			BindingResult result) {
		if (result.hasErrors()) {
			return "vehicle_service_update";
		}
		serviceService.update(service);
		return "redirect:display";
	}
	
	@RequestMapping(value="/serviceDisplay/{id}",method=RequestMethod.GET)
	public String serviceDisplay(@PathVariable("id")int id,ModelMap mm){
		mm.put("services", serviceService.findServiceByVehicle(vehicleService.find(id)));
		return "vehicle_service_display";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search(@RequestParam("monthValue") String monthValue,ModelMap mm){
		String[] str = monthValue.split("-");
		mm.put("services", serviceService.searchByMonth(str[0],str[1]));
		return "vehicle_service_display";
	}
}
