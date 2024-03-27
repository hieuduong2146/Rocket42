package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectDBLibrary {
	private Connection conn = null;
	private String url;
	private String user;
	private String password ;	
	
	
	
	public Connection getConnectMYSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Properties properties = PropertiesUtil.readProperties();
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
			conn = DriverManager.getConnection(url, user, password);
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
