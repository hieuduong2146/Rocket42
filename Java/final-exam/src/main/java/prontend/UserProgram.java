package prontend;

import util.JdbcUtil;

import java.sql.SQLException;

public class UserProgram {
    public static void main(String[] args) throws SQLException {

        UserFunction userFunction = new UserFunction();
        userFunction.showMenu();

    }
}
