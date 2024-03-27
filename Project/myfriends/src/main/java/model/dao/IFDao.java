package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.AddContact;
import model.bean.DanhMucBanBe;
import model.bean.ThongTinBanBe;

public class IFDao {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private ConnectDBLibrary connectDBLibrary;
	private PreparedStatement pst;
	public IFDao() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<ThongTinBanBe> getItems(){
		ArrayList<ThongTinBanBe> listFr = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM friends ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ThongTinBanBe objFr = new ThongTinBanBe(rs.getInt("fl_id"), rs.getString("fname"), rs.getString("preview_text"), rs.getTimestamp("date_create"));
				listFr.add(objFr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listFr;
	}
	public ArrayList<ThongTinBanBe> getItemByIds(int ifid ){
		ArrayList<ThongTinBanBe> listFr = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM friends WHERE fl_id =  " +ifid;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				ThongTinBanBe objFr = new ThongTinBanBe(rs.getInt("fl_id"), rs.getString("fname"), rs.getString("preview_text"), rs.getTimestamp("date_create"));
				listFr.add(objFr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listFr;
	}
	public ThongTinBanBe getDetails(int did) {
		ThongTinBanBe objFr = null;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM friends WHERE fid =  " +did;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				 objFr = new ThongTinBanBe(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview_text"), rs.getTimestamp("date_create") , rs.getString("picture"),rs.getString("detail"),rs.getInt("fl_id"),rs.getInt("count_number"));
				 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return objFr;
	}
	public int additem(AddContact addContact) {
		int result = 0;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "INSERT INTO contact (name,email,phone,content) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, addContact.getName());
			pst.setString(2, addContact.getEmail());
			pst.setInt(3, addContact.getPhone());
			pst.setString(4, addContact.getContent());
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
	public ArrayList<ThongTinBanBe> getlistCacnguoibankhac(ThongTinBanBe friends) {
		ArrayList<ThongTinBanBe> listCnbk = new ArrayList<>();
		
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM friends WHERE fid != ? AND fl_id = ?"; 
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,friends.getFid() );
			pst.setInt(2, friends.getFl_id());
			rs = pst.executeQuery();
			while (rs.next()) {
				ThongTinBanBe objfr = new ThongTinBanBe(rs.getInt("fid"), rs.getString("fname"), rs.getString("preview_text"), rs.getTimestamp("date_create") , rs.getString("picture"),rs.getString("detail"),rs.getInt("fl_id"),rs.getInt("count_number"));
				listCnbk.add(objfr);
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
		return listCnbk;
	}
	
}
