package BBS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;



public abstract class BbsAction {

    protected DataSource ds;
    protected Connection conn = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

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
}
