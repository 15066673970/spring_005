package com.jinan.www.jdbctemplate;

import java.beans.PropertyVetoException;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//��ʾjdbcģ��
public class Demo {
	@Test
	public void fun1() throws Exception {
		
		//0 ׼�����ӳ�
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
		dataSource.setUser("sdtest");
		dataSource.setPassword("dreamsoft");
		
		//1����JDBCģ�����
		JdbcTemplate jTemplate  = new JdbcTemplate();
		jTemplate.setDataSource(dataSource);
		
		//��дsql����ִ��
		String sql = "insert into t_user values(1,'rose')";
		
		jTemplate.update(sql);
	}
	
}
