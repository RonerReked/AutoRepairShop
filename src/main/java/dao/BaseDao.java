package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> entityClass;

	public BaseDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return sessionFactory.getCurrentSession()
				.createCriteria(entityClass.getName()).list();
	}

	public void create(T instance) {
		sessionFactory.getCurrentSession().persist(instance);
	}

	public void update(T instance) {
		sessionFactory.getCurrentSession().merge(instance);
	}

	public void delete(T instance) {
		sessionFactory.getCurrentSession().delete(instance);
	}

	@SuppressWarnings("unchecked")
	public T find(Object primarykey) {
		return (T) sessionFactory.getCurrentSession().get(entityClass,
				(Serializable) primarykey);
	}

}
