package vn.edu.vinaenter.model.dao;	

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Cmt;
import vn.edu.vinaenter.model.News;

@Repository
public class CommentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String FIND_ALL = "SELECT c.*,n.name FROM comment AS c INNER JOIN news AS n ON c.idnews = n.id ";	
	private static final String FIND_ONE_CMT = "SELECT c.*,n.name FROM comment AS c INNER JOIN news AS n ON c.idnews = n.id WHERE c.idnews = ? ORDER BY id DESC";
	private static final String INSERT_ONE = "INSERT INTO comment(comment,idnews) VALUES (?,?) ";	
	
	private static final String DELETE_ONE = "DELETE FROM comment WHERE id = ? ";	
	
	private static final String COUNT_ALL = "SELECT COUNT(*) FROM comment AS c INNER JOIN news AS n ON c.idnews = n.id";
	private static final String FIND_PAGINATION = "SELECT c.*,n.name FROM comment AS c INNER JOIN news AS n ON c.idnews = n.id ORDER BY time DESC LIMIT ?,?";
	private RowMapper<Cmt> getRowMapper(){
		return new RowMapper<Cmt>() {
			@Override
			public Cmt mapRow(ResultSet rs, int rowNum) throws SQLException {
				Cmt Cmt = new Cmt(rs.getInt("id"), rs.getString("comment"),rs.getTimestamp("time") 						
						, new News(rs.getInt("id"),rs.getString("name"), null, null,rowNum , null, rowNum, null));
				return Cmt;
			}
		};
	}
	
	public List<Cmt> Find_ALL(){
		return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}

	public List<Cmt> getItems(int id) {
		return jdbcTemplate.query(FIND_ONE_CMT, getRowMapper(),new Object[] {id});
	}

	public void add(String comment,int id) {
		 jdbcTemplate.update(INSERT_ONE,new Object[] {comment,id});	
	}

	public int edit(int id) {		
		return jdbcTemplate.update(DELETE_ONE,new Object[] {id}); 
	}

	public int countItems() {
		 return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

	public List<Cmt> getItemsPagination(int offset) {
		return jdbcTemplate.query(FIND_PAGINATION,getRowMapper(),new Object[]{offset,Defines.ROW_COUNT_CMT}); 
	}

}
