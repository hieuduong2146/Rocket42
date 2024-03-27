package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Library.ConnectDBLibrary;
import model.bean.DanhMucTin;

public class CatDAO {
	private ConnectDBLibrary connectDBLibrary;
	private Statement st;
	private ResultSet rs;
	private Connection conn;
	
	public CatDAO() {
		connectDBLibrary = new ConnectDBLibrary(); 
	}
	public ArrayList<DanhMucTin> getItems(){
		ArrayList<DanhMucTin> listDMT = new ArrayList<>();
		conn = connectDBLibrary.getConnectMYSQL(); 
		String sql = "SELECT * FROM danhmuctin";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				DanhMucTin objDMT = new DanhMucTin(rs.getInt("ID_DanhMucTin"),rs.getString("TenDanhMucTin"));
				listDMT.add(objDMT);
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
		return listDMT;
	}
	public DanhMucTin getItem(int idDMT) {
		DanhMucTin objDMT = null;
		conn = connectDBLibrary.getConnectMYSQL();
		String sql = "SELECT * FROM danhmuctin WHERE  ID_DanhMucTin = " + idDMT;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				objDMT = new DanhMucTin(rs.getInt("ID_DanhMucTin"), rs.getString("TenDanhMucTin"));
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
		
		return objDMT;
	}

}
