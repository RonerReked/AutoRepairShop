package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.VehicleDao;
import entities.Vehicles;

@Service
@Transactional
public class VehicleService {

	@Autowired
	VehicleDao vehicleDao;

	public List<Vehicles> findAll() {
		return vehicleDao.findAll();
	}

	public void create(Vehicles vehicle) {
		vehicleDao.create(vehicle);
	}

	public void delete(Vehicles vehicle) {
		vehicleDao.delete(vehicle);
	}

	public void update(Vehicles vehicle) {
		vehicleDao.update(vehicle);
	}

	public Vehicles find(Object primarykey) {
		return vehicleDao.find(primarykey);
	}

}
