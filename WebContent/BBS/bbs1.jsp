<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.PostBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
  Map<String,PostBean> modelMap = (Map<String,PostBean>)request.getAttribute("modelMap");
  String bbsName = request.getParameter("BBS");
  List<PostBean> postList=(List<PostBean>)modelMap.get(bbsName);
  int postPerPage = 15;
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= bbsName %></title>
</head>
<body>
  <div>PostNumber</div>
  <div>Title</div>
  <div>userName</div>
  <div>ReadCount</div>
  <div>WriteDate</div>
  <br>
  <%
  	int postCnt;
  	if(postList.size()<postPerPage){
  	    postCnt = postList.size();
  	}else{
  	    postCnt = postPerPage;
  	}
    for(int i=0;i<postCnt;i++){
      PostBean content = (PostBean)postList.get(i);
  %>
  <div><%= content.getPostNumber() %></div>
  <div><%= content.getTitle() %></div>
  <div><%= content.getUserName() %></div>
  <div><%= content.getReadCount() %></div>
  <div><%= content.getWriteDate() %></div>
  <br>
  <%
    }
  %>

</body>
</html>