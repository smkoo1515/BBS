<%@ page import="BBS.Beans.UserInfoBean" %>

<%
	if(request.getAttribute("hasSession").equals("true")){
	    UserInfoBean userInfo = (UserInfoBean)request.getSession().getAttribute("bbsUserInfo");
%>
	<%= userInfo.getName() %><br>
  <a href="">logout</a>
<%
	}else{
%>

<%
	}
%>