package BBS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;



public abstract class BbsAction {

    private DataSource ds;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public abstract BbsView doServiceWith(HttpServletRequest req);

    public BbsAction(){
        super();

        try{
            Context init = new InitialContext();
            ds = (DataSource) init.lookup("java:comp/env/jdbc/MySQL");
            conn = ds.getConnection();
        }catch(Exception ex){
            System.out.println("error: " + ex);
            return;
        }
    }

    protected ResultSet executeQuery(String query){
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(query);
                rs = pstmt.executeQuery();
            } catch (SQLException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            }
        }
        return rs;
    }
}
