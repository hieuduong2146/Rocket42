package repository;

import entity.User;
import util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {


    public User findByIdEmployee(int p_id) throws SQLException {
        String sql = "SELECT * FROM users WHERE project_id = ? AND role = 'EMPLOYEE' ";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql);
        ) {
            pStmt.setInt(1,p_id);

            try (ResultSet rs = pStmt.executeQuery()) {
                if(rs.next()){
                    User user = new User();
                    int id = rs.getInt("id");
                    user.setId(id);
                    String fullname = rs.getString("full_name");
                    user.setFullname(fullname);
                    String email = rs.getString("email");
                    user.setEmail(email);
                    String password = rs.getString("password");
                    user.setPassword(password);
                    String role = rs.getString("role");
                    user.setRole(role);
                    return user;
                } else {
                    return null;
                }

            }

        }
    }

    public List<User> findAllManager() throws SQLException {
        String sql = "SELECT * FROM users WHERE role = 'MANAGER'";
        try (
                Connection connection = JdbcUtil.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ){
            List<User> users = new ArrayList<>();
            while (rs.next()){
                User user = new User();
                int id = rs.getInt("id");
                user.setId(id);
                String fullname = rs.getString("full_name");
                user.setFullname(fullname);
                String email = rs.getString("email");
                user.setEmail(email);
                String password = rs.getString("password");
                user.setPassword(password);
                String role = rs.getString("role");
                user.setRole(role);
                users.add(user);
            }
            return users;
        }
    }

    public User findByEmailAndPassword(String email,String password) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql);
        ) {
            pStmt.setString(1,email);
            pStmt.setString(2,password);
            try (ResultSet rs = pStmt.executeQuery()) {
                if(rs.next()){
                    User user = new User();
                    int id = rs.getInt("id");
                    user.setId(id);
                    String fullname = rs.getString("full_name");
                    user.setFullname(fullname);
                    user.setEmail(email);
                    user.setPassword(password);
                    String role = rs.getString("role");
                    user.setRole(role);
                    return user;
                } else {
                    return null;
                }

            }
        }
    }
}
