package com.niit.sonebackend.dao;

import java.util.List;

import com.niit.sonebackend.model.User;

public interface UserDAO {
	public boolean save(User user);
	public boolean update(User user);
	public boolean delete(User user);
	public User get(String id);
	public List<User> list();
}
