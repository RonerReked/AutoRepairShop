package dao;

import org.springframework.stereotype.Repository;

import entities.Mechanic;
import entities.Services;

@Repository
public class MechanicDao extends BaseDao<Mechanic>{
	 public MechanicDao() {
		 super(Mechanic.class);
	}
}
