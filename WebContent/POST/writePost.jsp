<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.UserInfoBean" %>

<%
	UserInfoBean userInfo = (UserInfoBean)request.getSession().getAttribute("bbsUserInfo");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write Post</title>
</head>
<body>

  <form method="post" action="EditPost.do">
  	<input type="hidden" name="BBS" value="<%=request.getParameter("BBS")%>">
	username: <%= userInfo.getName() %><br>
	title <input type="text" name="title" size=45><br>
	content <input type="text" name="content" size=500>
	<input type="submit">
  </form>
</body>
</html>