<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.ReplyBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>


<%
  Map<String,Object> modelMap = (Map<String,Object>)request.getAttribute("modelMap");
  String bbsName = request.getParameter("BBS");
  String postNumber = request.getParameter("POSTNO");
  List<ReplyBean> replytList=(List<ReplyBean>)modelMap.get(bbsName+"@"+postNumber);
  Integer replyCount =  (Integer)request.getAttribute("replyCount");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=bbsName%>@<%=postNumber%></title>
</head>
<body>

<br><br>
  <div><%= replyCount %> replies</div>

  <br>
  <%
  	int cnt = replytList.size();

    for(int i=0;i<cnt;i++){
      ReplyBean reply = (ReplyBean)replytList.get(i);
  %>
  <div style="width:30px; text-align:center; float:left"><%= reply.getReplyNumber() %></div>
  <div style="width:400px; float:left"><%= reply.getContent() %></div></a>
  <div style="width:80px; text-align:center; float:left"><%= reply.getUserName() %></div>
  <div style="width:30px; text-align:center; float:left"><%= reply.getReplyDate() %></div>
  <br>
  <%
    }
  %>


<br><br><br>
  <%
	if(request.getSession().getAttribute("bbsUserInfo") != null){
  %>
  <a href="#">Write</a>
  <%
	}
  %>


</body>
</html>