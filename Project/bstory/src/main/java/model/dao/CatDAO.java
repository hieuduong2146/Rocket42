package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Category;
import util.ConnectDBLibrary;

public class CatDAO {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	private Statement st;
	private ConnectDBLibrary connectDBLibrary;
	
	public CatDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ArrayList<Category> getitems() {
		ArrayList<Category> items = new ArrayList<>();
		conn =connectDBLibrary.getConnectMYSQL();	
		String sql = "select  * from categories  order by id_cat desc";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Category item = new Category(rs.getInt("id_cat"), rs.getString("name"));
				items.add(item);
			}
		} catch (SQLException e) {
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
		return items ;
	}

	public int addcat(Category item) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "insert into categories (name) values(?)";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, item.getName());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public Category getitemByid(int id) {
		Category items = null;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "select * from categories where id_cat = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				items = new Category(id,rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return items;
	}

	public int editCat(Category items) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "update categories set name = ? where id_cat = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, items.getName());
			pst.setInt(2, items.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

	public int delitems(int id) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "delete from categories where id_cat = ?";
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

	

	

}
