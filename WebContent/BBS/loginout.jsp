<%@ page import="BBS.Beans.UserInfoBean" %>

<%
UserInfoBean userInfo = (UserInfoBean)request.getSession().getAttribute("bbsUserInfo");
	if(userInfo != null){
%>
    Name: <%= userInfo.getName() %><br>
    <a href="Logout.do">logout</a>
<%
	}else{
%>
	<form method="post" action="Login.do">
  	id <input type="text" name="id" size=14><br>
	passwd <input type="password" name="passwd" size=30><br>
	<input type="submit" value="sign in">
  </form>
  <input type="button" value="sign up">
<%
	}
%>