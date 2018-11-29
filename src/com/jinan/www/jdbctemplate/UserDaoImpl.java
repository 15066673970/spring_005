package com.jinan.www.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.support.ResourceTransactionManager;

import com.jinan.www.bean.User;

import oracle.net.aso.u;
//使用jdbc模板实现增删改查
//2.3 从jdbcdaosupport类继承后就不需要自己手动准备下面的JdbcTemplate模板对象了。
//public class UserDaoImpl extends JdbcDaoSupport implements UserDao
public class UserDaoImpl implements UserDao {

	//2.3 
//	private JdbcTemplate jt;
	private JdbcTemplate jt;
	
	@Override
	public void save(User u) {
		String sql = "insert into t_user values(?,?)";
//2.3	
//		super.getJdbcTemplate().update(sql,u.getId(),u.getName());
		jt.update(sql,u.getId(), u.getName());
	}

	@Override
	public void delete(Integer id) {
		String sql = "delete from t_user where id = ?";

		jt.update(sql, id);
	}

	@Override
	public void update(User u) {
		String sql = "update t_user set name=? where id=?";

		jt.update(sql, u.getName(),u.getId());

	}

	@Override
	public User getById(Integer id) {
		String sql ="select * from t_user where id=?";
		
		return jt.queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));;
				return user;
			}},id);
		
	}

	@Override
	public int getTotalCount() {

		String sql = "select count(*) from t_user";
		
		Integer count = jt.queryForObject(sql,Integer.class);
		
		return count;
	}

	@Override
	public List<User> getAll() {

		String sql = "select * from t_user";
		
		List<User> list = jt.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));;
				return user;
			}});
		return list;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	

}
