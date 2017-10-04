package com.metacube.shoppingcart.dao;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericHibernateDao<T,ID extends Serializable> implements BaseDao<T, ID>{
	
	  @Autowired
	  public SessionFactory sessionFactory;

	  public SessionFactory getSessionFactory() {
			return sessionFactory;
		}

		public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}

		private Class<T> modelClass;

		public Class<T> getModelClass()
		{
			return modelClass;
		}

		public GenericHibernateDao(Class<T> modelClass) {
			this.modelClass = modelClass;
		}

		
	@Override
	public T findOne(Serializable primaryKey) {
	
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<T> findAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(getModelClass());
	
		Iterable<T> personsList = cr.list();
		return personsList;
	}

	@Override
	public void delete(Serializable primaryKey) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public T create(T entity) {
		return null;
	}

}
