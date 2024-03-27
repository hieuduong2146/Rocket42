package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Contact;
import util.ConnectDBLibrary;

public class ContactDao {
	private Connection conn;
	private ResultSet rs;
	private PreparedStatement pst;
	private Statement st;
	private ConnectDBLibrary connectDBLibrary;
	
	
	public ContactDao() {
		connectDBLibrary = new ConnectDBLibrary();
	}


	public ArrayList<Contact> contact() {
		ArrayList<Contact> itemsct = new ArrayList<>();		
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "select * from contact";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Contact ct = new Contact(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("website"),rs.getString("message")) ;			
				itemsct.add(ct);
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
		
		return itemsct;
	}


	public int delcontact(int id) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "delete from contact where id = ?";
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


	public int addcontact(Contact contact) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "insert into contact ( name, email, website,message) values(?,?,?,?)";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1,contact.getName() );
			pst.setString(2, contact.getEmial());
			pst.setString(3, contact.getWebsite());
			pst.setString(4, contact.getMessage());
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
