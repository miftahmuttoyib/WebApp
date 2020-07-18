package dao;


import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    private final static String userName = "root";
    private final static String password = "r00t";
    private final static String url = "jdbc:mysql://localhost:3306/webapp";
    DSLContext db;
    Connection conn = null;
    public DAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        openConnection();
    }

    void openConnection() {
        if (conn != null) return;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db = DSL.using(conn, SQLDialect.MYSQL);
    }

    void closeConnection() {
        if (conn!= null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}