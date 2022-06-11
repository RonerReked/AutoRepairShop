package dao;

import org.springframework.stereotype.Repository;

import entities.Vehicles;

@Repository
public class VehicleDao extends BaseDao<Vehicles>{
	 public VehicleDao() {
		 super(Vehicles.class);
	}
}
