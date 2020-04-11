package dao;


import com.sun.jersey.api.client.GenericType;
import obj.Complaint;
import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

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
        } //finally {
//            if (conn!= null) {
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        db = DSL.using(conn, SQLDialect.MYSQL);
    }

//    protected <E> List<E> getAll(TableLike<?> tableName, Class<? extends E> type) {
//        return db.select().from(tableName).fetch().into(type);
//    }

    protected Record getById(String tableName, String id) {
        return db.fetchOne(tableName, "");
    }
}