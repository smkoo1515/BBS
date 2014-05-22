<%@ page import="BBS.Beans.UserInfoBean" %>

<%
UserInfoBean userInfo = (UserInfoBean)request.getSession().getAttribute("bbsUserInfo");
	if(userInfo != null){
%>
	<%= userInfo.getName() %><br>
  <a href="logout.do">logout</a>
<%
	}else{
%>
	<form method="post" action="login.do">
  	id <input type="text" name="id" size=14><br>
	passwd <input type="passwd" name="passwd" size=30><br>
	<input type="submit" value="login">
  </form>
<%
	}
%>