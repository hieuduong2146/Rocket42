package vn.edu.vinaenter.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.Role;
@Repository
public class RoleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String FIND_ALL = "SELECT * FROM role";
	
	public List<Role> getItems(){
		return jdbcTemplate.query(FIND_ALL, new BeanPropertyRowMapper<>(Role.class));
	}
}
