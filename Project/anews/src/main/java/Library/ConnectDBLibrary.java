package Library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDBLibrary {
	private Connection conn;
	private String url;
	private String username;
	private String pass;	
	private String db;
	
	public ConnectDBLibrary() {
		this.db = "tintuc";
		this.url = "jdbc:mysql://localhost:3306/"+db+"?useUnicode=truecharacterEncoding=UTF-8";
		this.username = "root";	
		this.pass = "";
		
	}
	public Connection getConnectMYSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, pass);
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public static void main(String[] args) {
		ConnectDBLibrary connectDBLibrary = new ConnectDBLibrary();
		System.out.println(connectDBLibrary.getConnectMYSQL());
	}
}
