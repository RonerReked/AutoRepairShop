package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MechanicDao;
import entities.Mechanic;

@Service
@Transactional
public class MechanicService {

	@Autowired
	MechanicDao mechanicDao;

	public List<Mechanic> findAll() {
		return mechanicDao.findAll();
	}
	public Mechanic find(Object primarykey){
		return mechanicDao.find(primarykey);
	}
}
