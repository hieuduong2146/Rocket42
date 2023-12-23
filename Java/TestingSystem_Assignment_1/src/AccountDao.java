import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public AccountDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
           // String url = "jdbc:mysql://161.35.160.4:3306/DerpartmentManagement";
            String url = "jdbc:mysql://localhost:3306/DerpartmentManagement";
            String user = "root";
            String password = "aaaa";
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InstantiationException e) {
            System.out.println(e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
    }

    public Account getAccount(long id) {
        Account account = null;
        try {
            rs = stmt.executeQuery("select * from account where account_id = " + id);
            while (rs.next()) {
                account = new Account();
                account.AccountId = rs.getInt("account_id");
                account.userName = rs.getString("username");
                account.fullName = rs.getString("fullname");
               // account.gender = Gender.valueOf(rs.getString("gender"));
                account.createDate = rs.getDate("createDate");
               // account.salary = rs.getInt("salary");
                
                Department department = new Department();
                department.departmentId = rs.getLong("department_id");
                account.department = department;
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return account;
    }

    public Account[] getAllAccount() {
        List<Account> list = new ArrayList<>();
        Account account;
        try {
            rs = stmt.executeQuery("select * from Account");
            while (rs.next()) {
                account = new Account();
                account.AccountId = rs.getInt("account_id");
                account.email = rs.getString("email");
                account.userName = rs.getString("username");
                account.fullName = rs.getString("fullname");
              //  account.gender = Gender.valueOf(rs.getString("gender"));
                account.createDate = rs.getDate("createDate");
                //account.salary = rs.getInt("salary");

                Department department = new Department();
                department.departmentId = rs.getLong("department_id");
                account.department = department;
                
                list.add(account);
            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return list.toArray(new Account[0]);
    }
    
    public void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
