<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%><%@taglib
	uri="http://java.sun.com/jsf/core" prefix="f"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PlayRoom WebApplication</title>
</head>
<center style="height: 304px; ">
<body>
		<img style="width: 976px; height: 281px; background-color: White" src="C:/Users/John/Eclipse -JEE WorkSpaces/Workspace/PlayRoomWebApp2/WebContent/Img/Logo2.png">
		<form action="LoginControll" method="post">
        Enter username : <input type="text" name="username" style="width: 148px; "> <BR>
        Enter password : <input type="password" name="password" style="width: 147px; "> <br><BR>
        <input type="submit" class="button" name="SignIn" value="Sign In" />
		<input type="submit" class="button" name="SignUp" value="Sign Up" />
		</form><p style="color:red;">Login failed, try again..
		</center>
		<img style="height: 191px; width: 273px" background-color: White" src="C:/Users/John/Eclipse -JEE WorkSpaces/Workspace/PlayRoomWebApp2/WebContent/Img/icon.png">
	</body>
	
</html>