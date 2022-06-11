package dao;

import org.springframework.stereotype.Repository;

import entities.Customers;

@Repository
public class CustomerDao extends BaseDao<Customers>{
	 public CustomerDao() {
		 super(Customers.class);
	}
}
