<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.PostBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>


<%
  Map<String,Object> modelMap = (Map<String,Object>)request.getAttribute("modelMap");
  String bbsName = request.getParameter("BBS");
  List<PostBean> postList=(List<PostBean>)modelMap.get(bbsName);
  String pageStr = request.getParameter("PAGE");
  Integer pages = 1;
  if(pageStr != null){
      pages = Integer.parseInt(pageStr);
  }
  Integer postPerPage = (Integer)request.getAttribute("postPerPage");
  Integer postCount =  (Integer)request.getAttribute("postCount");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= bbsName %></title>
</head>
<body>
<%@ include file="loginout.jsp" %>
<br><br>
  <div><%= postCount %> posts</div>
  <div style="width:30px; text-align:center; float:left">No</div>
  <div style="width:400px; text-align:center; float:left">Title</div>
  <div style="width:80px; text-align:center; float:left">User</div>
  <div style="width:30px; text-align:center; float:left">RC</div>
  <div style="width:80px; text-align:center; float:left">Date</div>
  <br>
  <%
  	int cnt;
  	if(postList.size()<postPerPage){
  	    cnt = postList.size();
  	}else{
  	    cnt = postPerPage;
  	}
    for(int i=0;i<cnt;i++){
      PostBean content = (PostBean)postList.get(i);
  %>
  <div style="width:30px; text-align:center; float:left"><%= content.getPostNumber() %></div>
  <a href="CtrPost.do?BBS=<%=bbsName%>&&CMD=Read&&POSTNO=<%=content.getPostNumber()%>"><div style="width:400px; float:left"><%= content.getTitle() %></div></a>
  <div style="width:80px; text-align:center; float:left"><%= content.getUserName() %></div>
  <div style="width:30px; text-align:center; float:left"><%= content.getReadCount() %></div>
  <div style="width:80px; text-align:center; float:left"><%= content.getWriteDate() %></div>
  <br>
  <%
    }
  %>

  <%
	Integer lastPage = (int)Math.ceil((double)postCount/postPerPage);
	Integer navIndex = (pages-1)/10*10+1;
	for(int i=0; i < 10; i++){
	    if(navIndex > lastPage){
	        break;
	    }
	    if(navIndex == pages){
  %><%=navIndex%><%
	    }else{
  %>
  	<a href="ViewBbs.do?BBS=<%=bbsName%>&PAGE=<%=navIndex%>"> <%=navIndex%> </a>
  <%
	    }
  		navIndex++;
    }
  %>

<br><br><br>
<a href="Index.jsp">Index</a>

  <br><br><br>
  <%
	if(request.getSession().getAttribute("bbsUserInfo") != null){
  %>
  <a href="CtrPost.do?BBS=<%=bbsName%>&CMD=Write">Write</a>
  <%
	}
  %>


</body>
</html>