package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.bean.Category;
import model.bean.Stories;
import util.ConnectDBLibrary;
import util.DefineUtil;

public class StrDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	private Statement st;
	private ConnectDBLibrary connectDBLibrary;
	
	public StrDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ArrayList<Stories> getitems(int offset) {
		ArrayList<Stories> items = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		
		String sql = "SELECT s.id_story as sid,s.name as sname,preview_text,detail_text,date_create,picturer,"
				+ "counter,c.id_cat, c.name AS cname,s.uid as suid FROM stories AS s INNER JOIN categories AS c "
				+ "ON s.id_cat = c.id_cat ORDER BY sid DESC limit ? , ?;";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();		
			while (rs.next()) {
				int uid = rs.getInt("suid");
				int id = rs.getInt("sid");
				 String name = rs.getString("sname");
				 String previewText = rs.getString("preview_text");
				 String detail_text = rs.getString("detail_text");
				 Timestamp datecreate = rs.getTimestamp("date_create");
				 String picture = rs.getString("picturer");
				 int counter = rs.getInt("counter");
				 Category category = new Category(rs.getInt("id_cat"),rs.getString("cname"));
				 Stories item = new Stories(id, name, previewText, datecreate, picture, counter, category,uid);
				 items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}

	public int addItem(Stories item) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "insert into stories ( name, preview_text, detail_text,date_create,picturer,counter,id_cat,uid) values(?,?,?,?,?,?,?,?)";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1,item.getName() );
			pst.setString(2, item.getPreview_text());
			pst.setString(3, item.getDetail_text());
			pst.setTimestamp(4, item.getDate_create());
			pst.setString(5, item.getPicture());
			pst.setInt(6, item.getCounter());
			pst.setInt(7, item.getCategory().getId());
			pst.setInt(8, item.getUid());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Stories getitem(int id) {
		Stories item = null;
		conn = connectDBLibrary.getConnectMYSQL();		
		String sql = "SELECT id_story,name, preview_text, detail_text,date_create,picturer,counter,id_cat From stories where id_story = ?";
				
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				 String name = rs.getString("name");
				 String previewText = rs.getString("preview_text");
				 String detail_text = rs.getString("detail_text");
				 Timestamp datecreate = rs.getTimestamp("date_create");
				 String picture = rs.getString("picturer");
				 int couter = rs.getInt("counter");
				 Category category = new Category(rs.getInt("id_cat"),null);
				 item = new Stories(id, name, previewText, datecreate, picture, couter, category);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs	.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return item;
	}

	public int edit(Stories item) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "UPDATE stories SET name = ?,preview_text = ?,detail_text = ? ,date_create = ?,picturer = ?,id_cat = ? WHERE id_story = ? ";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1,item.getName() );
			pst.setString(2, item.getPreview_text());
			pst.setString(3, item.getDetail_text());	
			pst.setTimestamp(4, item.getDate_create());
			pst.setString(5, item.getPicture());	
			pst.setInt(6, item.getCategory().getId());			
			pst.setInt(7, item.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int delitem(int id) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "delete from stories  WHERE id_story = ? ";
		try {
			pst= conn.prepareStatement(sql);				
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int numberOfitems() {
conn = connectDBLibrary.getConnectMYSQL();
		
		String sql = "SELECT count(*)AS count From stories";
				
		try {
			st = conn.createStatement();			
			rs = st.executeQuery(sql);
			if (rs.next()) {
				 int count = rs.getInt("count");
				 return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs	.close();					
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}

	public ArrayList<Stories> getitemsPagination(int offset) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Stories> searchSong(String search) {
		ArrayList<Stories> items = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		
		String sql = "SELECT s.id_story as sid,s.name as sname,preview_text,detail_text,date_create,picturer,"
				+ "counter,c.id_cat, c.name AS cname,s.uid as suid FROM stories AS s INNER JOIN categories AS c "
				+ "ON s.id_cat = c.id_cat  where s.name like ? ;";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%"+search+"%");		
			rs = pst.executeQuery();		
			while (rs.next()) {
				int uid = rs.getInt("suid");
				int id = rs.getInt("sid");
				 String name = rs.getString("sname");
				 String previewText = rs.getString("preview_text");
				 String detail_text = rs.getString("detail_text");
				 Timestamp datecreate = rs.getTimestamp("date_create");
				 String picture = rs.getString("picturer");
				 int counter = rs.getInt("counter");
				 Category category = new Category(rs.getInt("id_cat"),rs.getString("cname"));
				 Stories item = new Stories(id, name, previewText, datecreate, picture, counter, category,uid);
				 items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}

	public int getnumberGetItem(int id) {
	conn = connectDBLibrary.getConnectMYSQL();		
		String sql = "SELECT count(*)AS count From stories where id_cat = ?  ";
				
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);		
			rs = pst.executeQuery();
			if (rs.next()) {
				 int count = rs.getInt("count");
				 return count;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && pst != null && conn != null) {
				try {
					rs	.close();		
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}

	public ArrayList<Stories> getitemsByCategoryPagenation(int offset, int catID) {
		ArrayList<Stories> items = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		
		String sql = "SELECT s.id_story as sid,s.name as sname,preview_text,detail_text,date_create,picturer,"
				+ "counter,c.id_cat, c.name AS cname,s.uid as suid FROM stories AS s INNER JOIN categories AS c "
				+ "ON s.id_cat = c.id_cat where c.id_cat = ? ORDER BY sid DESC limit ? , ?;";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, catID);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();		
			while (rs.next()) {
				int uid = rs.getInt("suid");
				int id = rs.getInt("sid");
				 String name = rs.getString("sname");
				 String previewText = rs.getString("preview_text");
				 String detail_text = rs.getString("detail_text");
				 Timestamp datecreate = rs.getTimestamp("date_create");
				 String picture = rs.getString("picturer");
				 int counter = rs.getInt("counter");
				 Category category = new Category(rs.getInt("id_cat"),rs.getString("cname"));
				 Stories item = new Stories(id, name, previewText, datecreate, picture, counter, category,uid);
				 items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}

	public ArrayList<Stories> getitems() {
		ArrayList<Stories> items = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		
		String sql = "SELECT s.id_story as sid,s.name as sname,preview_text,detail_text,date_create,picturer,"
				+ "counter,c.id_cat, c.name AS cname,s.uid as suid FROM stories AS s INNER JOIN categories AS c "
				+ "ON s.id_cat = c.id_cat ORDER BY sid DESC  ;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				int uid = rs.getInt("suid");
				int id = rs.getInt("sid");
				 String name = rs.getString("sname");
				 String previewText = rs.getString("preview_text");
				 String detail_text = rs.getString("detail_text");
				 Timestamp datecreate = rs.getTimestamp("date_create");
				 String picture = rs.getString("picturer");
				 int counter = rs.getInt("counter");
				 Category category = new Category(rs.getInt("id_cat"),rs.getString("cname"));
				 Stories item = new Stories(id, name, previewText, datecreate, picture, counter, category,uid);
				 items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}
	
	public ArrayList<Stories> getItems(int number) {
		ArrayList<Stories> items = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		
		String sql = "SELECT s.id_story as sid,s.name as sname,preview_text,detail_text,date_create,picturer,"
				+ "counter,c.id_cat, c.name AS cname,s.uid as suid FROM stories AS s INNER JOIN categories AS c "
				+ "ON s.id_cat = c.id_cat ORDER BY sid DESC limit ? ;";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, number);
			rs = pst.executeQuery();		
			while (rs.next()) {
				int uid = rs.getInt("suid");
				int id = rs.getInt("sid");
				 String name = rs.getString("sname");
				 String previewText = rs.getString("preview_text");
				 String detail_text = rs.getString("detail_text");
				 Timestamp datecreate = rs.getTimestamp("date_create");
				 String picture = rs.getString("picturer");
				 int counter = rs.getInt("counter");
				 Category category = new Category(rs.getInt("id_cat"),rs.getString("cname"));
				 Stories item = new Stories(id, name, previewText, datecreate, picture, counter, category,uid);
				 items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}

	public void increaseview(int id) {
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "UPDATE stories SET counter = counter + 1 WHERE id_story = ? ";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1,id);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public ArrayList<Stories> relatedItem(Stories str, int i) {
		ArrayList<Stories> items = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		
		String sql = "SELECT s.id_story as sid,s.name as sname,preview_text,detail_text,date_create,picturer,"
				+ "counter,c.id_cat, c.name AS cname,s.uid as suid FROM stories AS s INNER JOIN categories AS c "
				+ "ON s.id_cat = c.id_cat where c.id_cat = ? && s.id_story != ? ORDER BY sid DESC limit ? ;";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, str.getCategory().getId());
			pst.setInt(2, str.getId());
			pst.setInt(3, i);
			rs = pst.executeQuery();		
			while (rs.next()) {
				int uid = rs.getInt("suid");
				int id = rs.getInt("sid");
				 String name = rs.getString("sname");
				 String previewText = rs.getString("preview_text");
				 String detail_text = rs.getString("detail_text");
				 Timestamp datecreate = rs.getTimestamp("date_create");
				 String picture = rs.getString("picturer");
				 int counter = rs.getInt("counter");
				 Category category = new Category(rs.getInt("id_cat"),rs.getString("cname"));
				 Stories item = new Stories(id, name, previewText, datecreate, picture, counter, category,uid);
				 items.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs != null && st != null && conn != null) {
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return items;
	}


	
}
