package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Library.ConnectDBLibrary;
import model.bean.TinTuc;

public class NewsDAO {
	private Connection conn;
	private ConnectDBLibrary connectDBLibrary;
	private Statement st;
	private ResultSet rs;
	
	public NewsDAO() {
		connectDBLibrary = new ConnectDBLibrary();
	}
	public ArrayList<TinTuc> getItems(){
		ArrayList<TinTuc> listTT = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM tintuc ORDER BY ID_Tintuc DESC ";		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TinTuc objTT = new TinTuc(rs.getInt("ID_TinTuc"),rs.getNString("TenTinTuc"),(rs.getString("MoTa")));
				listTT.add(objTT);
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
		return listTT;
	}
	public ArrayList<TinTuc> getItemsByID(int idDMT) {
		ArrayList<TinTuc> listTT = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT*FROM tintuc WHERE ID_DanhMucTin = "+idDMT;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				TinTuc objTT = new TinTuc(rs.getInt("ID_TinTuc"),rs.getString("TenTinTuc"), rs.getString("MoTa"));
				listTT.add(objTT);
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
		
		
		return listTT;
	}
	public TinTuc getItems(int idNews) {
		TinTuc objTT = null;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM tintuc WHERE ID_TinTuc = "+ idNews;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objTT = new TinTuc(rs.getInt("ID_TinTuc"), rs.getString("TenTinTuc"), rs.getString("MoTa"),rs.getString("ChiTiet"));
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
		
		return objTT;
	}
}
