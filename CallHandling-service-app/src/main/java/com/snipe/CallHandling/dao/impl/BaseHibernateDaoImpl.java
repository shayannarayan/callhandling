package com.snipe.CallHandling.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.snipe.CallHandling.dao.BaseHibernateDao;



public class BaseHibernateDaoImpl<E, PK extends Serializable> implements
		BaseHibernateDao<E, PK> {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public PK save(E newInstance) {
		return (PK) getSessionFactory().getCurrentSession().save(newInstance);
	}


	public void update(E transientObject) {
		getSessionFactory().getCurrentSession().update(transientObject);
	}

	public void saveOrUpdate(E transientObject) {
		getSessionFactory().getCurrentSession().saveOrUpdate(transientObject);
	}

	public void delete(E persistentObject) {
		getSessionFactory().getCurrentSession().delete(persistentObject);
	}

	public E findById(PK id, Class<E> type) {
		return (E) getSessionFactory().getCurrentSession().get(type, id);
	}

	public List<E> findAll(Class<E> type) {
		return getSessionFactory().getCurrentSession().createCriteria(type).list();
	}

}
