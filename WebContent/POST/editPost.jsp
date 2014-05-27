<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.PostBean" %>
<%@ page import="BBS.Beans.UserInfoBean" %>
<%@ page import="java.util.Map" %>

<%
	UserInfoBean userInfo = (UserInfoBean)request.getSession().getAttribute("bbsUserInfo");
	Map<String,Object> postMap = (Map<String,Object>)request.getAttribute("modelMap");
	String bbsName = (String)postMap.get("bbsName");
	PostBean post = (PostBean)postMap.get("post");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write Post</title>
</head>
<body>

  <form method="post" action="UpdatePost.do">
  	<input type="hidden" name="BBS" value="<%=request.getParameter("BBS")%>">
  	<input type="hidden" name="POSTNO" value="<%=post.getPostNumber()%>">
	username: <%= userInfo.getName() %><br>
	title <input type="text" name="TITLE" value="<%= post.getTitle() %>" size=45><br>
	content <input type="text" name="CONTENT" value="<%= post.getContent() %>" size=500>
	<input type="submit">
  </form>
</body>
</html>