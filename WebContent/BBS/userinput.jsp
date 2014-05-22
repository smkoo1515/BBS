<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register</title>


</head>


<body bgcolor="#FFFFFF">
<table width="600" border="0" cellspacing="0" cellpadding="5">
  <tr bgcolor="#3399CC"> 
    <td height="39" class="normalbold"><font size="+1" color="#FFFFFF">user info</font></td>
  </tr>
  <tr>
    <td class="normal">hello! for use this BBS. please register your account <br>

  </tr>
</table>
<form method="post" action="UserInfo.do" name="userinput">
  <table width="600" border="1" cellspacing="0" cellpadding="3" bordercolor="#000000">
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">user ID</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="id" size="50">
        <!input type="button" name="confirm_id" value="IDcheck" OnClick="openConfirmid(document.userinput.id.value)">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">PW</div>
      </td>
      <td width="154" class="normal"> 
        <input type="password" name="passwd">
      </td>

    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179" height="23"> 
        <div align="center">user name</div>
      </td>
      <td colspan="3" height="23" class="normal"> 
        <input type="text" name="name">
      </td>
    </tr>

    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">birthday</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="year">
        year 
        <select name="month">
          <option value="01">01</option>
          <option value="02">02</option>
          <option value="03">03</option>
          <option value="04">04</option>
          <option value="05">05</option>
          <option value="06">06</option>
          <option value="07">07</option>
          <option value="08">08</option>
          <option value="09">09</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
        </select>
        month 
        <select name="day">
          <option value="01">01</option>
          <option value="02">02</option>
          <option value="03">03</option>
          <option value="04">04</option>
          <option value="05">05</option>
          <option value="06">06</option>
          <option value="07">07</option>
          <option value="08">08</option>
          <option value="09">09</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
          <option value="13">13</option>
          <option value="14">14</option>
          <option value="15">15</option>
          <option value="16">16</option>
          <option value="17">17</option>
          <option value="18">18</option>
          <option value="19">19</option>
          <option value="20">20</option>
          <option value="21">21</option>
          <option value="22">22</option>
          <option value="23">23</option>
          <option value="24">24</option>
          <option value="25">25</option>
          <option value="26">26</option>
          <option value="27">27</option>
          <option value="28">28</option>
          <option value="29">29</option>
          <option value="30">30</option>
          <option value="31">31</option>
        </select>
        day </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">gender</div>
      </td>
      <td colspan="3" class="normal"> 
        <select name="gender">
          <option value="male">male</option>
          <option value="female">female</option>
        </select>
      </td>
    </tr>
    <tr> 
    
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">E-Mail</div>
      </td>
      <td colspan="3" class="normal"> 
        <input type="text" name="email">
      </td>
    </tr>
    <tr> 
      <td bgcolor="#FFCCCC" class="normalbold" width="179"> 
        <div align="center">interest</div>
      </td>
      <td colspan="3" class="normal"> 
        <select name="interest">
          <option value="HARDWARE">HARDWARE</option>
          <option value="C#">C#</option>
          <option value="WEB">WEB</option>
          <option value="DBASE">DBASE</option>
          <option value="JAVA">JAVA</option>
          <option value="PHP">PHP</option>
          <option value="ETC">ETC</option>
        </select>
      </td>
    </tr>
    <tr> 
      <td colspan="4" class="normal"> 
        <div align="center"> 
          <input type="submit" name="confirm" value="confirm" >
          <!input type="button" name="confirm" value="confirm" OnClick="checkUserInput()"> 
          <input type="reset" name="reset" value="cancel">
        </div>
      </td>
    </tr>
  </table>
</form>

</body>
</body>
</html>