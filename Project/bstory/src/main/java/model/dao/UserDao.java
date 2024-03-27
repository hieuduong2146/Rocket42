package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.User;
import util.ConnectDBLibrary;

public class UserDao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	private Statement st;
	private ConnectDBLibrary connectDBLibrary;
	
	public UserDao() {
		connectDBLibrary = new ConnectDBLibrary();
	}

	public ArrayList<User> getUSer() {
		ArrayList<User> listus = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "select * from users";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				User us = new User(rs.getInt("id"), rs.getString("usersname"), rs.getString("password"), rs.getString("fullname"),rs.getString("role")) ;
				listus.add(us);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listus;
	}

	public boolean hasUser(String username) {
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "select * from users where usersname = ?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public int adduser(User user) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "insert into users ( usersname, password,fullname,role) values(?,?,?,?)";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			pst.setString(4, user.getRole());
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

	public User editByid(int id) {
		User us = null;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "select * from users where id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()) {
				us = new User(id, rs.getString("usersname"), rs.getString("password"), rs.getString("fullname"), rs.getString("role"));
			}
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
		
		return us;
	}

	public int editus(User objus) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "UPDATE `users` SET `usersname`= ? ,`password`= ? ,`fullname`= ? ,`role`= ? WHERE id = ? ";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, objus.getUsername());
			pst.setString(2, objus.getPassword());
			pst.setString(3, objus.getFullname());
			pst.setString(4, objus.getRole());
			pst.setInt(5, objus.getId());
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

	public int deluser(int id) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "delete from users where id = ?";
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

	public User roleUser(String username, String password) {
		User us = null;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT u.id,usersname,r.role,fullname FROM users AS u INNER JOIN role AS r ON u.role = r.role where usersname = ? and password = ? ";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id");	
				String fullname = rs.getString("fullname");
				String role = rs.getString("role");
				us = new User(id, username, password, fullname,role);
			}
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
		
		return us;
		
	}
	
}
