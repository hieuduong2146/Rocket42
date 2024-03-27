package vn.edu.vinaenter.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.Skill;

@Repository
public class SkillDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String FIND_ALL = "SELECT * FROM skills ";
	private static final String Find_ONE_BY_ID = "SELECT * FROM skills WHERE id = ?";
	private static final String Insert_ONE = "INSERT INTO  skills(name,value) VALUES (?,?) ";
	private static final String DELETE_ONE_BY_ID = "DELETE  FROM skills WHERE id = ?";
	private static final String UPDATE_ONE_BY_ID = "UPDATE skills SET name= ? , value = ? WHERE id = ?";
	public BeanPropertyRowMapper<Skill> getRowMapper(){
		return new BeanPropertyRowMapper<>(Skill.class);
	} 
	public List<Skill> getitems() {
		 return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}
	public int add(Skill skill) {
		 return jdbcTemplate.update(Insert_ONE,new Object[] {skill.getName(),skill.getValue()});
	}
	public int delete(int id) {
		 return jdbcTemplate.update(DELETE_ONE_BY_ID,new Object[] {id});
	}
	public Skill getItems(int id) {
		 return jdbcTemplate.queryForObject(Find_ONE_BY_ID,getRowMapper(), new Object[]{id});
	}
	public int edit(Skill skill) {
		 return jdbcTemplate.update(UPDATE_ONE_BY_ID,new Object[] {skill.getName(),skill.getValue(),skill.getId()});
	}
}
