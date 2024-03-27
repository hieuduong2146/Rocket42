package vn.edu.vinaenter.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Category;
import vn.edu.vinaenter.model.Land;
import vn.edu.vinaenter.model.News;
import vn.edu.vinaenter.model.Project;

@Repository
public class NewsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String FIND_ALL = "SELECT n.*,c.cname FROM news AS n INNER JOIN categories AS c ON n.cid = c.cid ";
	private static final String COUNT_VIEWS = "SELECT n.*,c.cname FROM news AS n INNER JOIN categories AS c ON n.cid = c.cid ORDER BY count_views DESC LIMIT 3";
	private static final String NEWS_CAT_BY_ID = "SELECT n.*,c.cname FROM news AS n INNER JOIN categories AS c ON n.cid = c.cid WHERE c.cid = ?";

	private static final String COUNT_ALL = "SELECT COUNT(*) FROM news AS n INNER JOIN categories AS c ON n.cid = c.cid";
	private static final String FIND_PAGINATION = "SELECT n.*,c.cname FROM news AS n INNER JOIN categories AS c ON n.cid = c.cid ORDER BY date_create DESC LIMIT ?,? ";
	private static final String  INSERT_ONE ="INSERT INTO news (name,picture,cid,detail) VALUES (?,?,?,?)";
	private static final String FIND_BY_RELATED = "SELECT n.*,c.cname FROM news AS n INNER JOIN categories AS c ON n.cid = c.cid WHERE  n.cid = ? AND n.id != ? LIMIT ?";

	private static final String FIND_ONE_BY_ID = "SELECT n.*,c.cname FROM news AS n INNER JOIN categories AS c ON n.cid = c.cid WHERE  n.id = ? ";
	private static final String  DELETE_BY_ID ="DELETE FROM news WHERE id = ?";
	
	private static final String  EDIT_ONE_BY_ID = "UPDATE news SET name=?,cid=?,picture=?,detail =? WHERE id = ?";
	private static final String Search = "SELECT n.*,c.cname FROM news AS n INNER JOIN categories AS c ON n.cid = c.cid WHERE name like  ? ";

	private static final String ADD_COUNT = "UPDATE `news` SET `count_views`=count_views+1 WHERE id = ?";
	private static final String EDIT_STT_1 = "UPDATE news SET status = ? WHERE id = ?  ";
	private static final String EDIT_STT_0 = "UPDATE news SET status = ? WHERE id = ?  ";
	
	private static final String FIND_STT = " SELECT status FROM news WHERE id= ? ";
	private RowMapper<News> getRowMapper(){
		return new RowMapper<News>() {
			@Override
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News news = new News(rs.getInt("id"), rs.getString("name"),rs.getString("picture"), 
						rs.getString("detail"), rs.getInt("count_views"),
						 rs.getTimestamp("date_create"), rs.getInt("status"), new Category(rs.getInt("cid"),rs.getString("cname")));
				return news;
			}
		};
	}

//	public int edit( Project project) {
//		return jdbcTemplate.update(EDIT_ONE_BY_ID, new Object[] {project.getName(),project.getLink(),project.getPicture(),project.getId()});
//	}

	public List<News> getitems() {
		 return jdbcTemplate.query(FIND_ALL, getRowMapper());
	}
	public int countItems() {
		 return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	 }
	public List<News> getItemsPagination(int offset) {
		return jdbcTemplate.query(FIND_PAGINATION,getRowMapper(),new Object[]{offset,Defines.ROW_COUNT}); 
	}

	public int add(News news) {
		return jdbcTemplate.update(INSERT_ONE,new Object[] {news.getName(),news.getPicture(),news.getCategory().getCid(),news.getDetail()});
	}

	public News getItem(int id) {
		 return jdbcTemplate.queryForObject(FIND_ONE_BY_ID,getRowMapper(),new Object[]{id});
	}

	public int del(int id) {
		return jdbcTemplate.update(DELETE_BY_ID,new Object[]{id});
	}

	public int edit( News news) {
		return jdbcTemplate.update(EDIT_ONE_BY_ID,new Object[] {news.getName(),news.getCategory().getCid(),news.getPicture(),news.getDetail(),news.getId()});
	}

	public List<News> getitems(String search) {
		 return jdbcTemplate.query(Search, getRowMapper(),new Object[]{"%"+search+"%"});
	}

	public List<News> getRelatedTiem(News newone, int i) {
		return jdbcTemplate.query(FIND_BY_RELATED, getRowMapper(),new Object[]{newone.getCategory().getCid(),newone.getId(),i});
	}

	public List<News> coutview() {
		return jdbcTemplate.query(COUNT_VIEWS,getRowMapper()); 

	}

	public List<News> getitems(int cid) {
		return jdbcTemplate.query(NEWS_CAT_BY_ID,getRowMapper(),new Object[]{cid}); 
	}

	public int countviews(int id) {
		return jdbcTemplate.update(ADD_COUNT,new Object[] {id});
	}

	public void editstt1(int i, int aid) {
		jdbcTemplate.update(EDIT_STT_1,new Object[] {i,aid});
		
	}
	public void editstt0(int i, int aid) {
		jdbcTemplate.update(EDIT_STT_0,new Object[] {i,aid});
		
	}

	

	public int getstt(int aid) {
		 return jdbcTemplate.queryForObject(FIND_STT,Integer.class,new Object[] {aid});
	}
	
}
