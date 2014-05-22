package BBS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;


public abstract class BbsAction {

    private DataSource ds;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    private static String SQLPath = BbsAction.class.getResource("/").getPath().replaceFirst("/WEB-INF/.*$", "/SQL/");

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

    private String readSQLfrom(String sqlFile) throws FileNotFoundException{
        String sql = "";
        try(BufferedReader br = new BufferedReader(new FileReader(SQLPath + sqlFile))) {
            for(String line = br.readLine(); line != null; line = br.readLine()){
                sql = sql + " " +  line;
            }
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        return sql;
    }

    private String makeSql(String query, Map<String, String> params){
        if(params != null && !params.isEmpty()){
            for(String key : params.keySet()){
                query = query.replaceAll("[$]"+key+"[$]", params.get(key));
            }
        }
        return query;
    }

    protected boolean executeQuery(String fileName, Map<String, String> sqlParams) throws SQLException {
        if(conn != null){
            try {
                String query = makeSql(readSQLfrom(fileName),sqlParams);
                pstmt = conn.prepareStatement(query);
                System.out.println(query);
                if(query.toLowerCase().contains("select")){
                    rs = pstmt.executeQuery();
                    result = resultSetToArrayList(rs);
                }else{
                    pstmt.executeUpdate(query);
                }
                return true;
      
            } catch (FileNotFoundException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
                return false;
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
