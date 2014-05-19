<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.PostBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
  Map<String,PostBean> modelMap = (Map<String,PostBean>)request.getAttribute("modelMap");
  String bbsName = request.getParameter("BBS");
  List<PostBean> postList=(List<PostBean>)modelMap.get(bbsName);
  String pageStr = request.getParameter("PAGE");
  if(pageStr != null){
      Integer pages = Integer.parseInt(pageStr);
  }
  Integer postPerPage = (Integer)request.getAttribute("postPerPage");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= bbsName %></title>
</head>
<body>
  <div style="width:30px; text-align:center; float:left">No</div>
  <div style="width:400px; text-align:center; float:left">Title</div>
  <div style="width:80px; text-align:center; float:left">User</div>
  <div style="width:30px; text-align:center; float:left">RC</div>
  <div style="width:80px; text-align:center; float:left">Date</div>
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
  <div style="width:30px; text-align:center; float:left"><%= content.getPostNumber() %></div>
  <div style="width:400px; float:left"><%= content.getTitle() %></div>
  <div style="width:80px; text-align:center; float:left"><%= content.getUserName() %></div>
  <div style="width:30px; text-align:center; float:left"><%= content.getReadCount() %></div>
  <div style="width:80px; text-align:center; float:left"><%= content.getWriteDate() %></div>
  <br>
  <%
    }
  %>

</body>
</html>