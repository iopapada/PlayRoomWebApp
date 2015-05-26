
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PlayRoom WebApplication</title>
</head>
<center style="height: 304px; ">
<body>
		<img style="width: 976px; height: 281px; background-color: White" src="<%= request.getContextPath()%>/Img/Logo.jpg"/>
		<form action="LoginControll" method="post">
        Enter username : <input type="text" name="username" style="width: 148px; "> <BR>
        Enter password : <input type="password" name="password" style="width: 147px; "> <br><BR>
        <input type="submit" class="button" name="SignIn" value="Sign In" />
		<input type="submit" class="button" name="SignUp" value="Sign Up" />
		</form><p style="color:white;">Login failed, try again..
			<script type="text/javascript">
function timedMsg()
{
var t=setInterval("change_time();",1000);
}
function change_time()
{
var d = new Date();
var curr_hour = d.getHours();
var curr_min = d.getMinutes();
var curr_sec = d.getSeconds();	
document.getElementById('time').innerHTML = curr_hour+':'+curr_min+':'+curr_sec;
}
timedMsg();
</script>
<table>
<tr>
<td>Current time is :</td>
<td id="time"></td>
<tr>
</table> 
</center>
		<img style="height: 191px; width: 273px" background-color: White" src="<%= request.getContextPath()%>/Img/icon.png"/>
	</body>
	
</html>