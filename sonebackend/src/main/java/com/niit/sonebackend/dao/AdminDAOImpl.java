package com.niit.sonebackend.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.niit.sonebackend.model.Admin;

public class AdminDAOImpl implements AdminDAO {
 private SessionFactory sessionFactory;
 public AdminDAOImpl(SessionFactory sessionFactory)
 {
	 this.sessionFactory=sessionFactory;
 }
	public boolean save(Admin admin)
	{
		sessionFactory.getCurrentSession().save(admin);
		return true;
	}
	public boolean update(Admin admin) {
		sessionFactory.getCurrentSession().update(admin);
		return true;
	}
	public boolean delete(Admin admin) {
		sessionFactory.getCurrentSession().delete(admin);
		return true;
	}
	public Admin get(String id) {
		String hql ="from Admin where id ="+"'"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return null;
	}
	

}
