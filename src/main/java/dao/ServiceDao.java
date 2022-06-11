package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import entities.Services;
import entities.Vehicles;

@Repository
public class ServiceDao extends BaseDao<Services> {
	public ServiceDao() {
		super(Services.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Services> findAll() {
		List<Services> services = sessionFactory.getCurrentSession()
				.createCriteria(Services.class).list();
		for (Services service : services) {
			Hibernate.initialize(service.getCustomers());
			Hibernate.initialize(service.getMechanic());
			Hibernate.initialize(service.getVehicles());
		}
		return services;
	}

	@SuppressWarnings("unchecked")
	public List<Services> findServiceByVehicle(Vehicles vehicle) {
		List<Services> services = sessionFactory.getCurrentSession()
				.createCriteria(Services.class)
				.add(Restrictions.eq("vehicles", vehicle)).list();
		for (Services service : services) {
			Hibernate.initialize(service.getCustomers());
			Hibernate.initialize(service.getMechanic());
			Hibernate.initialize(service.getVehicles());
		}
		return services;
	}

	@SuppressWarnings("unchecked")
	public List<Services> searchByMonth(String year, String month) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"from Services services where month(services.createdate) = :month and year(services.createdate) = :year");
		query.setString("month", month);
		query.setString("year", year);
		List<Services> services = query.list();
		for (Services service : services) {
			Hibernate.initialize(service.getCustomers());
			Hibernate.initialize(service.getMechanic());
			Hibernate.initialize(service.getVehicles());
		}
		return services;
	}

}
