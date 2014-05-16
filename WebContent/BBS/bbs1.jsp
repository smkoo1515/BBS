<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.PostBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
    Map<String,PostBean> modelMap = (Map<String,PostBean>)request.getAttribute("modelMap");
	String bbsName = (String)request.getAttribute("BBS");
	List<PostBean> postList=(List<PostBean>)modelMap.get(bbsName);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Sample</title>
</head>
<body>
	View Sample<br>
	<%
	    for(int i=0;i<postList.size();i++){
					PostBean content = (PostBean)postList.get(i);
	%>
		listno : <%= content.getContentNumber() %><br>
		userid : <%= content.getUserId() %><br>
		contentno : <%= content.getContentNumber() %><br>
		<br>
	<%
		}
	%>
</body>
</html>