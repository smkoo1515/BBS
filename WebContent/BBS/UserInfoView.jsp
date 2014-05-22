<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BBS.Beans.UserInfoBean"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>

<%
System.out.println((String)request.getAttribute("id"));
System.out.println((String)request.getAttribute("name"));
System.out.println((String)request.getAttribute("email"));
System.out.println((String)request.getAttribute("gender"));
System.out.println((String)request.getAttribute("birthday"));
System.out.println((String)request.getAttribute("interest"));
System.out.println((String)request.getAttribute("passwd"));

	String id = (String)request.getAttribute("id");
	String name = (String)request.getAttribute("name");
	String email = (String)request.getAttribute("email");
	String gender = (String)request.getAttribute("gender");
	String birthday = (String)request.getAttribute("birthday");
	String interest = (String)request.getAttribute("interest");
	String passwd = (String)request.getAttribute("passwd");
 

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>user information details</title>
</head>
<body>





<table width="270" border="0" cellspacing="0" cellpading="5">
  <tr bgcolor="#3399cc">
   <td height="39" class="normalbold">
    <%=name%> thanks for join us!!
   </td>
  </tr>
  <tr>
   <td class="normal">
     <p> finally end up for registration<br>
     this is requested your ID & Password</p>
     <p align="center"> LOGGED ID:<%=id%><br>
        PASSWORD:<%=passwd %><br>
     <a href="">go to login</a>
     </p>
   </td>
  </tr>
 </table>







	<br>

</body>
</html>