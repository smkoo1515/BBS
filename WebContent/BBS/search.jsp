<form action="Search.do" method="post">
<select name="SEARCHTYPE">
<option value="Title">Title</option>
<option value="Name">Name</option>
<input type="hidden" name="BBS" value="<%=request.getParameter("BBS")%>">
<input type="text" name="KEYWORD">
<input type="submit" name="Search">
</select>
</form>