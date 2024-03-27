package vn.edu.vinaenter.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.Category;

@Repository
public class CategoryDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String Find_All = "SELECT * FROM categories ";
	private static final String Find_ONE_BY_ID = "SELECT * FROM categories WHERE cid = ?";
	private static final String INSERT_ONE = "INSERT INTO  categories(cname) VALUES (?) ";
	private static final String DELETE_ONE_BY_ID = "DELETE  FROM categories WHERE cid = ?";
	private static final String UPDATE_ONE_BY_ID = "UPDATE categories SET name= ? WHERE cid = ?";
//	private static final String Search = "SELECT * FROM categories WHERE cname like  ? ";
		
	public BeanPropertyRowMapper<Category> getRowMapper(){
		return new BeanPropertyRowMapper<>(Category.class);
	} 
	
	public List<Category> getItems() {		
		 return jdbcTemplate.query(Find_All, getRowMapper());
	}
	public int add(Category category) {
		 return jdbcTemplate.update(INSERT_ONE,new Object[] {category.getCname()});
	}
	public int delete(int id) {
		
		return jdbcTemplate.update(DELETE_ONE_BY_ID,new Object[] {id});
	}
	
	public Category getItems(int id) {
		 return jdbcTemplate.queryForObject(Find_ONE_BY_ID,getRowMapper(), new Object[]{id});
	}
	
	public int edit(Category category) {
		
		 return jdbcTemplate.update(UPDATE_ONE_BY_ID,new Object[] {category.getCname(),category.getCid()});
	}
//	
//	public List<Category> searchItems(String search) {
//		 return jdbcTemplate.query(Search, getRowMapper(),new Object[]{"%"+search+"%"});
//	}
		  
}
