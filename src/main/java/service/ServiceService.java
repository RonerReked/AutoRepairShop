package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ServiceDao;
import entities.Services;
import entities.Vehicles;

@Service
@Transactional
public class ServiceService {

	@Autowired
	ServiceDao serviceDao;

	public List<Services> findAll() {
		return serviceDao.findAll();
	}

	public void create(Services service) {
		serviceDao.create(service);
	}

	public void delete(Services service) {
		serviceDao.delete(service);
	}

	public void update(Services service) {
		serviceDao.update(service);
	}

	public Services find(Object primarykey) {
		return serviceDao.find(primarykey);
	}

	public List<Services> findServiceByVehicle(Vehicles vehicle) {
		return serviceDao.findServiceByVehicle(vehicle);
	}

	public List<Services> searchByMonth(String year, String month) {
		return serviceDao.searchByMonth(year, month);
	}

}
