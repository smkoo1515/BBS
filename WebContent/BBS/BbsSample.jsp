<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.BbsContentBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<%
	Map<String,BbsContentBean> modelMap = (Map<String,BbsContentBean>)request.getAttribute("modelMap");


	List<BbsContentBean> sampleList=(List<BbsContentBean>)modelMap.get("bbsSample");
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
		for(int i=0;i<sampleList.size();i++){
			BbsContentBean content = (BbsContentBean)sampleList.get(i);
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