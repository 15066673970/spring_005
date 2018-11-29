package com.jinan.www.jdbctemplate;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jinan.www.bean.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo2 {
	@Resource(name="userDao")
	private UserDao userDao;
	
	@Test
	public void fun2() {
		User u = new User();
		u.setId(3);
		u.setName("javck");
		userDao.save(u);
	}
	
	
	@Test
	public void fun3() {
		User u = new User();
		u.setId(3);
		u.setName("jack");
		userDao.update(u);
	}
	
	@Test
	public void fun4() {
		userDao.delete(2);
	}
	
	@Test
	public void fun5() {
System.out.println(userDao.getTotalCount());		
	}
	
	
	@Test
	public void fun6() {
		System.out.println(userDao.getById(3));
	}
	
	
	@Test
	public void fun7() {
		System.out.println(userDao.getAll());
	
	}
}
