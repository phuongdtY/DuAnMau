package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class jdbcUntil {

    static String user = "sa", pass = "123456", url = "jdbc:sqlserver://localhost:1433;databaseName=FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041;encrypt=true;trustServerCertificate=true";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(jdbcUntil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // phan loai prepare, truyen tham so vao sql
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps;
        if (sql.trim().startsWith("{")) {
            ps = conn.prepareCall(sql);// proc
        } else {
            ps = conn.prepareStatement(sql);// SQL
        }
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        return ps;
    }

//    public static ResultSet getAll(String sql) throws SQLException {
//        Connection conn = DriverManager.getConnection(url, user, pass);
//        PreparedStatement ps;
//        ps = conn.prepareStatement(sql);// SQL
//        return ps.executeQuery();
//    }
// update dung thay doi du lieu insert update delete
    public static int update(String sql, Object... args) throws SQLException {
        PreparedStatement ps = getStmt(sql, args);
        try {
            return ps.executeUpdate();
        } finally {
            ps.getConnection().close();
        }
    }

    // query dung truy van du lieu
    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement ps = getStmt(sql, args);// truyen tham so vao ham getStmt va nhan lai preparedStatement
        return ps.executeQuery();
    }

    // value
    public static Object value(String sql, Object... args) throws SQLException {

        ResultSet rs = jdbcUntil.query(sql, args);
        if (rs.next()) {
            return rs.getObject(0);
        }
        rs.getStatement().getConnection().close();
        return null;
    }

}
