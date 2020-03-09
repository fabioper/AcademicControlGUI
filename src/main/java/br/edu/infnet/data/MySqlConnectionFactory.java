package br.edu.infnet.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory {
    public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public final static String DB_URL = "jdbc:mysql://localhost:3306/academic_control?useTimezone=true&serverTimezone=UTC";
    private static String user = "root";
    private static String password = "";

    public static Connection connect() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(DB_URL, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
