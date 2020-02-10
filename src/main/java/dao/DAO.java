package dao;


import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DAO {
    private final static String userName = "root";
    private final static String password = "r00t";
    private final static String url = "jdbc:mysql://localhost:3306/webapp";
    DSLContext db;
    DAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        db = DSL.using(conn, SQLDialect.MYSQL);
    }

    protected Result<Record> getAll(String tableName) {
        return db.select().from(tableName).fetch();
    }

    protected Record getById(String tableName, String id) {
        return db.fetchOne(tableName, "");
    }
}