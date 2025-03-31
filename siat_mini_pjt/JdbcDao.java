import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import todo.model.domain.TodoRequestDTO;

import java.sql.DriverManager;

public class JdbcDao {
    /* try {
         * 1. driver loading : 1번만
         * 2. Connection   (2번~6번 1 싸이클)
         * 3. Statement, PreparedStatement (SQL)
         * 4. ResultSet executeQuery() - Select
         *    int executeUpdate() - Insert, Update, Delete
         * 5. ResultSet Handling
         * 6. Connection close
         * } catch() {
         * 
         * }
    */
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver" ;    // 상수
    public static final String URL = "jdbc:oracle:thin:@localhost:1521/xe";
    public static final String USER = "hr";
    public static final String PASSWORD = "hr";


    public JdbcDao() {
        try {
            Class.forName(DRIVER) ;
            System.out.println("1. Driver loading ok!!!") ;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int insertRow(TodoRequestDTO request) {
        System.out.println(">>> dao insertRow") ;
        int flag = 0 ;
        Connection conn = null ;
        PreparedStatement pstmt = null ;
        String insertSQL = "INSERT INTO JDBC_TODO_TBL(SEQ, TITLE, CONTENT, PRIORITY) " +
                            "VALUES(JDBC_SEQ.NEXTVAL, ?,?,?)" ;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD) ;
            pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, request.getTitle()) ;
            pstmt.setString(2, request.getContent()) ;
            pstmt.setString(3, request.getStatus()) ;
            flag = pstmt.executeUpdate() ;
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag ;
    }

    public int deleteRow(int seq) {
        System.out.println(">>> dao deleteRow");
        int flag = 0 ;
        Connection conn = null ;
        PreparedStatement pstmt = null ;
        String deleteSQL = "DELETE FROM JDBC_TODO_TBL WHERE SEQ = ?" ;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD) ;
            pstmt = conn.prepareStatement(deleteSQL);
            pstmt.setInt(1, seq) ;
            flag = pstmt.executeUpdate() ;
        
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag ;
    }

    public int updateRow(Map<String, Object> map) {
        System.out.println(">>> dao updateRow");
        int flag = 0 ;
        Connection conn = null ;
        PreparedStatement pstmt = null ;
        String updateSQL = "UPDATE JDBC_TODO_TBL " +
                            "SET CONTENT = ? , STATUS = ? " +
                            "WHERE SEQ = ?" ;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD) ;
            pstmt = conn.prepareStatement(updateSQL);
            pstmt.setString(1, (String) (map.get("content"))) ;
            pstmt.setString(2, (String) (map.get("status"))) ;
            pstmt.setInt(3, (Integer) (map.get("seq"))) ;
            flag = pstmt.executeUpdate() ;
        
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close() ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag ;
    }

}
