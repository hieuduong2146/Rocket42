package vn.edu.vinaenter.model.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.Project;

@Repository
public class ProjectDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String FIND_ALL = "SELECT * FROM project ";
	private static final String FIND_ONE_BY_ID = "SELECT * FROM project WHERE id = ?";
	private static final String  INSERT_ONE ="INSERT INTO project (name,link,picture) VALUES (?,?,?)";
	private static final String  DELETE_BY_ID ="DELETE FROM project WHERE id = ?";
	
	private static final String  EDIT_ONE_BY_ID = "UPDATE project SET name=?,link=?,picture=? WHERE id = ?";


	public BeanPropertyRowMapper<Project> getRowMapper(){
		return new BeanPropertyRowMapper<>(Project.class);
	} 
	
	public List<Project> getitems() {
		 return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}

	public int add( Project project) {
		 return jdbcTemplate.update(INSERT_ONE, new Object[] {project.getName(),project.getLink(),project.getPicture()});
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_BY_ID, new Object[] {id});
	}

	public Project getItem(int id) {
		 return jdbcTemplate.queryForObject(FIND_ONE_BY_ID, getRowMapper(),new Object[]{id});
	}

	public int edit( Project project) {
		return jdbcTemplate.update(EDIT_ONE_BY_ID, new Object[] {project.getName(),project.getLink(),project.getPicture(),project.getId()});
	}
}
