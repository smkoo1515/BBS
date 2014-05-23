<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.PostBean" %>
<%@ page import="BBS.Beans.UserInfoBean" %>
<%@ page import="java.util.Map" %>

<%
	String bbsName = request.getParameter("BBS");
	Map<String,Object> postMap = (Map<String,Object>)request.getAttribute("modelMap");
	String postNumber = request.getParameter("POSTNO");
	PostBean post = (PostBean)postMap.get(postNumber);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Read Post</title>
</head>
<body>
<%@ include file="/BBS/loginout.jsp" %><br><br>
	post number: <%=post.getPostNumber() %><br>
	user name: <%= post.getUserName() %><br>
	title: <%= post.getTitle() %><br>
	content: <%= post.getContent() %><br>
	write date: <%= post.getWriteDate() %><br>
	read count: <%= post.getReadCount() %><br>
	recommand: <%= post.getRecommandCount() %>
	<br><br><br>
  <%
    UserInfoBean userBean = (UserInfoBean)request.getSession().getAttribute("bbsUserInfo");
	if(userBean != null && userBean.getId().equals(post.getUserId())){
  %>
  <a href="DeletePost.do?BBS=<%=bbsName%>&&POSTNO=<%=post.getPostNumber()%>">Delete</a>
  <%
	}
  %>
</body>
</html>