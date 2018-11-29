package com.jinan.www.jdbctemplate;

import java.util.List;

import com.jinan.www.bean.User;


public interface UserDao {
	 
	
	//增
	void save(User u);
	//删
	void delete(Integer id);
	//改
	void update(User u);
	//查
	User getById(Integer id);
	//查
	int getTotalCount();
	//查
	List<User> getAll();
	
	
}
