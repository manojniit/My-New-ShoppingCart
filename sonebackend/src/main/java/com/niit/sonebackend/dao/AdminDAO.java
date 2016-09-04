package com.niit.sonebackend.dao;

import com.niit.sonebackend.model.Admin;

public interface AdminDAO {
	public boolean save(Admin admin);
	public boolean update(Admin admin);
	public boolean delete(Admin admin);
	public Admin get(String id);
	

}
