package BBS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;



public abstract class BbsAction {

    private DataSource ds;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private ArrayList<HashMap<String, String>> result;

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

    protected boolean executeQuery(String query) throws SQLException{
        if(conn != null){
            try {
                pstmt = conn.prepareStatement(query);
                if(query.toLowerCase().contains("select")){
                    rs = pstmt.executeQuery();
                    result = resultSetToArrayList(rs);
                }else{
                    pstmt.executeUpdate(query);
                }
                return true;

            } catch (SQLException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
            } finally{
                if(rs != null){rs.close();}
                if(pstmt != null){pstmt.close();}
            }
        }
        return false;
    }

    protected ArrayList<HashMap<String, String>> getResult(){
        return result;
    }

    private ArrayList<HashMap<String, String>> resultSetToArrayList(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCnt = metaData.getColumnCount();
        String[] columnName = new String[metaData.getColumnCount()];

        for(int i = 0; i < columnCnt; i++){
            columnName[i] = metaData.getColumnName(i + 1);
        }
        ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> resultMap;
        while(rs.next()){
            resultMap = new HashMap<String, String>();
            for(int i = 0; i < columnCnt; i++){
                resultMap.put(columnName[i], rs.getString(columnName[i]));
            }
            resultList.add(resultMap);
        }
        return resultList;
    }
}
