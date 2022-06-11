package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import entities.Customers;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public List<Customers> findAll() {
		return customerDao.findAll();
	}

	public void create(Customers customer) {
		customerDao.create(customer);
	}

	public void delete(Customers customer) {
		customerDao.delete(customer);
	}

	public void update(Customers customer) {
		customerDao.update(customer);
	}

	public Customers find(Object primarykey) {
		return customerDao.find(primarykey);
	}

}
