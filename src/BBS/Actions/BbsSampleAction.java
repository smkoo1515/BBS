package BBS.Actions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import BBS.BbsAction;
import BBS.BbsView;
import BBS.Beans.BbsContentBean;

public class BbsSampleAction extends BbsAction {
    //SelectItem selectItem = new SelectItem();

    @Override
    public BbsView doServiceWith(HttpServletRequest req) {
        List<BbsContentBean> contentList = selectBbsContentListFromDB();
        BbsView view = new BbsView();
        Map<String,Object> bbsMap = new HashMap<String,Object>();

        bbsMap.put("bbsSample", contentList);

        view.setModelMap(bbsMap);

        view.setViewPage("/BBS/BbsSample.jsp");

        return view;
    }

    private List<BbsContentBean> selectBbsContentListFromDB() {
        String tmpSql = "select * from list";
        List<BbsContentBean> beanList = new ArrayList<BbsContentBean>();
        try{
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(tmpSql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                BbsContentBean contentBean=new BbsContentBean();
                contentBean.setContentNumber(Integer.parseInt(rs.getString("listno")));
                contentBean.setUserId(rs.getString("userid"));
                contentBean.setContentTitle(rs.getString("title"));

                beanList.add(contentBean);
            }
            return beanList;
        }
        catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
        }
        finally{
            if(rs!=null) try{rs.close();}catch(SQLException sqex){}
            if(pstmt!=null) try{pstmt.close();}catch(SQLException sqex){}
        }

        return null;
    }
}
