package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectDBLibrary;
import model.bean.DanhMucBanBe;
import model.bean.ThongTinBanBe;

public class CatDao {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private ConnectDBLibrary connectDBLibrary;
	
	public CatDao() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<DanhMucBanBe> getItems (){
		ArrayList<DanhMucBanBe> listFR = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM friend_list";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DanhMucBanBe objFr = new DanhMucBanBe(rs.getInt("fl_id"), rs.getString("flname"));
				listFR.add(objFr);
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
		
		return listFR;
	}
	public DanhMucBanBe getitem(int ifid) {
		 DanhMucBanBe objFr = null;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM friend_list WHERE fl_id =  " +ifid;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				 objFr = new DanhMucBanBe(rs.getInt("fl_id"),rs.getString("flname"));
				
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
}
