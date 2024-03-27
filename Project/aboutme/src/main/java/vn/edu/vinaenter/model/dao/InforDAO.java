package vn.edu.vinaenter.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.model.Infor;

@Repository
public class InforDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String Find_All = "SELECT * FROM information ";
	private static final String Find_ONE_BY_ID = "SELECT * FROM information WHERE id = ?";
	private static final String INSERT_ONE = "INSERT INTO `information`(`name`, `birthday`, `email`, `address`, `phone`, `content`, `status`) VALUES (?,?,?,?,?,?,?) ";
	private static final String DELETE_ONE_BY_ID = "DELETE  FROM information WHERE id = ?";
	private static final String UPDATE_ONE_BY_ID = "UPDATE information SET name= ?,birthday=?,email=?,address=?,phone=?,content=?,status = ? WHERE id = ?";

		
	public BeanPropertyRowMapper<Infor> getRowMapper(){
		return new BeanPropertyRowMapper<>(Infor.class);
	}

	public List<Infor> getItems() {
		 return jdbcTemplate.query(Find_All, getRowMapper());
	}

	public int add( Infor infor) {
		 return jdbcTemplate.update(INSERT_ONE,new Object[] {infor.getName(),infor.getBirthday(),infor.getEmail(),infor.getAddress(),infor.getPhone(),infor.getContent(),infor.getStatus()});
	}

	public int delete(int id) {
		return jdbcTemplate.update(DELETE_ONE_BY_ID,new Object[] {id});
	}

	public Infor getItem(int id) {
		 return jdbcTemplate.queryForObject(Find_ONE_BY_ID,getRowMapper(), new Object[]{id});
	}

	public int edit( Infor infor) {
		 return jdbcTemplate.update(UPDATE_ONE_BY_ID,new Object[] {infor.getName(),infor.getBirthday(),infor.getEmail(),
				 infor.getAddress(),infor.getPhone(),infor.getContent(),infor.getStatus(),infor.getId()});
	}

	
	

		  
}
