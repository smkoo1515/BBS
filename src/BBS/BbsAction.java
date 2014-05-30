//　アクションの抽象クラス
//　データベース処理機能は抽象クラスで具現

//　ユーザーアクションはアクションをインプルメンテーションし、メインロジックを具現

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

    //　データベース接続用
    private DataSource ds;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    //　SQLファイルパス
    private static String SQLPath = BbsAction.class.getResource("/").getPath().replaceFirst("/WEB-INF/.*$", "/SQL/");

    //　Select Queryの結果を保管
    private ArrayList<HashMap<String, String>> result;

    //　アクションのメインロジック
    //　インプルメンテーション必要
    public abstract BbsView doServiceWith(HttpServletRequest req);

    //　初期化
    //　データベースに接続する
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
        //　context.xmlから情報を獲得
    }

    //　SQLファイルを読む
    private String[] readSQLfrom(String sqlFile) throws FileNotFoundException{
        String[] sql;
        String sqls = "";
        try(BufferedReader br = new BufferedReader(new FileReader(SQLPath + sqlFile))) {
            for(String line = br.readLine(); line != null; line = br.readLine()){
                sqls = sqls + " " +  line;
            }
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        sql = sqls.split(";");
        return sql;
    }

    //　「＄」キーワード置換で動的SQL文生成
    private String makeSql(String query, Map<String, String> params){
        if(params != null && !params.isEmpty()){
            for(String key : params.keySet()){
                query = query.replaceAll("[$]"+key+"[$]", params.get(key));
            }
        }
        return query;
    }

    //　実際Queryを実行するメソッド
    //　パラメータでQueryファイルの名前と置換マップが必要
    protected boolean executeQuery(String fileName, Map<String, String> sqlParams) throws SQLException {
        if(conn != null){
            try {
                //　SQLファイルを読み、置換して動的SQL文生成
                for (String sql : readSQLfrom(fileName)){
                    String query = makeSql(sql,sqlParams);
                    pstmt = conn.prepareStatement(query);
                 //　Select文チェック
                    if(query.toLowerCase().contains("select")){
                        //　Select文実行
                        rs = pstmt.executeQuery();
                        //　結果獲得
                        result = resultSetToArrayList(rs);
                    }else{
                        //　Select文以外実行
                        pstmt.executeUpdate(query);
                    }
                }

                return true;

            } catch (FileNotFoundException e) {
                // TODO 自動生成された catch ブロック
                e.printStackTrace();
                return false;
            //　データベースの接続終了を保障
            } finally{
                if(rs != null){rs.close();}
                if(pstmt != null){pstmt.close();}
            }
        }
        return false;
    }

    //Queryの結果を返す
    protected ArrayList<HashMap<String, String>> getResult(){
        return result;
    }

    //　Queryの結果を直観的な論理構造に加工
    //　RowはListのIndexで、Columnはテーブルのカラム名で特定
    private ArrayList<HashMap<String, String>> resultSetToArrayList(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        //　カラムサイズ
        int columnCnt = metaData.getColumnCount();
        String[] columnName = new String[metaData.getColumnCount()];

        //　カラム名
        for(int i = 0; i < columnCnt; i++){
            columnName[i] = metaData.getColumnName(i + 1);
        }
        ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> resultMap;
        while(rs.next()){
            //　カラム名キーにして値を保管
            resultMap = new HashMap<String, String>();
            for(int i = 0; i < columnCnt; i++){
                resultMap.put(columnName[i], rs.getString(columnName[i]));
            }
            //　ローはリストで保管
            resultList.add(resultMap);
        }
        return resultList;
    }
}
