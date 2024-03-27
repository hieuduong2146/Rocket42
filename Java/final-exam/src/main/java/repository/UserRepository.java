package repository;

import entity.User;
import util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> findAll() throws SQLException {
        String sql = "SELECT * FROM users";
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
                   user.setFullName(fullname);
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
                    user.setFullName(fullname);
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
    public User findById(int id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql);
        ) {
                pStmt.setInt(1,id);
                try (ResultSet rs = pStmt.executeQuery()) {
                    if(rs.next()){
                        User user = new User();
                        user.setId(id);
                        String fullname = rs.getString("full_name");
                        user.setFullName(fullname);
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
    public int create(String fullName , String email) throws SQLException {
        String sql = "INSERT INTO users (full_name,email) values (?,?)";
        try
                (
                        Connection connection = JdbcUtil.getConnection();
                        PreparedStatement pStmt = connection.prepareStatement(sql);

        ) {
            pStmt.setString(1,fullName);
            pStmt.setString(2,email);
            return pStmt.executeUpdate();

        }
    }

    public int delById(int id) throws SQLException {
        String sql = "DELETE FROM  users WHERE id = ? ";
        try
                (
                        Connection connection = JdbcUtil.getConnection();
                        PreparedStatement pStmt = connection.prepareStatement(sql);
                ) {
                     pStmt.setInt(1,id);
                      return pStmt.executeUpdate();

        }
    }
}
