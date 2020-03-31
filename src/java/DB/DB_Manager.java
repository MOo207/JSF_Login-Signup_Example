/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author Mohammed Al 3mawy
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Manager {

    static final String DB_URL = "jdbc:mysql://localhost/login&signup?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "";
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt=null;
    ResultSet rs = null;

    public DB_Manager() {

    }

    public void createConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public void releaseResources() throws Exception {
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
        if (rs != null) {
            rs.close();
        }
    }
    public ResultSet select (String Q)throws Exception
    {
            createConnection();
            stmt = conn.createStatement();
            rs=stmt.executeQuery(Q);
            return rs;
    }


    public ResultSet select(String Q, String p1, String p2) throws Exception {
        createConnection();
        pstmt = conn.prepareStatement(Q);
        pstmt.setString(1, p1);
        pstmt.setString(2, p2);
        rs = pstmt.executeQuery();
        return rs;
    }
    public void releaseResources2() throws Exception {
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
        if (rs != null) {
            rs.close();
        }
    }


    public void InsertUpdateDelete(String Q) throws Exception {
        createConnection();
        stmt = conn.createStatement();
        stmt.execute(Q);

        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }

    }
}
