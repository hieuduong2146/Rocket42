package frontend;

import util.JdbcUtil;

import java.sql.SQLException;

public class UserProgram {
    public static void main(String[] args) throws SQLException {
        UserFuntion userFuntion = new UserFuntion();

        userFuntion.login();
    }
}
