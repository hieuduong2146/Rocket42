package vn.edu.vinaenter.model.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.Way;

@Repository
public class WayDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static final String Find_All = "SELECT * FROM way ";
	private static final String INSERT_ONE = "INSERT INTO  way(name,time,classify) VALUES (?,?,?) ";
	private static final String DELETE_ONE_BY_ID = "DELETE  FROM way WHERE id = ?";
	private static final String Find_ONE_BY_ID = "SELECT * FROM way WHERE id = ?";
	private static final String UPDATE_ONE_BY_ID = "UPDATE way SET name= ? , time = ?,classify = ? WHERE id = ?";
	public BeanPropertyRowMapper<Way> getRowMapper(){
		return new BeanPropertyRowMapper<>(Way.class);
	}

	public List<Way> getItems() {
		 return jdbcTemplate.query(Find_All, getRowMapper());
	}

	public int add( Way way) {
		 return jdbcTemplate.update(INSERT_ONE,new Object[] {way.getName(),way.getTime(),way.getClassify()});
	}

	public int delete(int id) {
		return jdbcTemplate.update(DELETE_ONE_BY_ID,new Object[] {id});
	}

	public Way getItems(int id) {
		return jdbcTemplate.queryForObject(Find_ONE_BY_ID,getRowMapper(), new Object[]{id});
	}

	public int edit( Way way) {
		 return jdbcTemplate.update(UPDATE_ONE_BY_ID,new Object[] {way.getName(),way.getTime(),way.getClassify(),way.getId()});
	} 
}
