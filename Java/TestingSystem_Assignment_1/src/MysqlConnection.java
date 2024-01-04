import java.sql.*;

class MysqlConnection {
    public static void main(String args[]) throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/DerpartmentManagement", "root", "aaaa");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from com.vti.entity.Account");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}  