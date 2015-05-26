<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>

<script type="text/javascript">
function validateData(form)
{	
	/* var confpass = form.confpassword.value; 
	var pass = form.password.value; */
	var user = form.username.value;

	var rtele = /^\d{5}/;	
	var rmail = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
	
    var success = 1;
    
   	/* if (confpass!=pass || confpass.length==pass.length>0) {
        document.getElementById("passMsg").style.display = "block";
        form.password.style.backgroundColor = "yellow";
        form.password.style.border = "3px red solid";
		
        form.confpassword.style.backgroundColor = "yellow";
        form.confpassword.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.password.style.backgroundColor = "";
        form.password.style.border = "";
        form.confpassword.style.backgroundColor = "";
        form.confpassword.style.border = "";
        document.getElementById("passMsg").style.display = "none"; 
    } */
    if (!user) {
        document.getElementById("usernameMsg").style.display = "block";
        form.username.style.backgroundColor = "yellow";
        form.username.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.username.style.backgroundColor = "";
        form.username.style.border = "";
        document.getElementById("usernameMsg").style.display = "none";
    }
    
    if (!form.firstname.value) {
        document.getElementById("firstnameMsg").style.display = "block";
        form.firstname.style.backgroundColor = "yellow";
        form.firstname.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.firstname.style.backgroundColor = "";
        form.firstname.style.border = "";
        document.getElementById("firstnameMsg").style.display = "none";
    }
    if (!form.lastname.value) {
        document.getElementById("lastnameMsg").style.display = "block";
        form.lastname.style.backgroundColor = "yellow";
        form.lastname.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.lastname.style.backgroundColor = "";
        form.lastname.style.border = "";
        document.getElementById("lastnameMsg").style.display = "none";
    }
    if (!rtele.test(form.telephone.value)) {
        document.getElementById("teleMsg").style.display = "block";
        form.telephone.style.backgroundColor = "yellow";
        form.telephone.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.telephone.style.backgroundColor = "";
        form.telephone.style.border = "";
        document.getElementById("teleMsg").style.display = "none";
    }
    if (!rmail.test(form.email.value)) {
        document.getElementById("emailMsg").style.display = "block";
        form.email.style.backgroundColor = "yellow";
        form.email.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.email.style.backgroundColor = "";
        form.email.style.border = "";
        document.getElementById("emailMsg").style.display = "none";
    } 
    
    if (!form.addrstreet.value) {
        document.getElementById("addrStreetMsg").style.display = "block";
        form.addrstreet.style.backgroundColor = "yellow";
        form.addrstreet.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.addrstreet.style.backgroundColor = "";
        form.addrstreet.style.border = "";
        document.getElementById("addrStreetMsg").style.display = "none";
    }
    if (!form.addrnumber.value) {
        document.getElementById("addrNumMsg").style.display = "block";
        form.addrnumber.style.backgroundColor = "yellow";
        form.addrnumber.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.addrnumber.style.backgroundColor = "";
        form.addrnumber.style.border = "";
        document.getElementById("addrNumMsg").style.display = "none";
    }
    if (!form.city.value) {
        document.getElementById("cityMsg").style.display = "block";
        form.city.style.backgroundColor = "yellow";
        form.city.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.city.style.backgroundColor = "";
        form.city.style.border = "";
        document.getElementById("cityMsg").style.display = "none";
    }
    if (!form.country.value) {
        document.getElementById("countryMsg").style.display = "block";
        form.country.style.backgroundColor = "yellow";
        form.country.style.border = "3px red solid";
        success = 0;
    }
    else {
        form.country.style.backgroundColor = "";
        form.country.style.border = "";
        document.getElementById("countryMsg").style.display = "none";
    }
    
    if(success==0) {
    
        alert("The form is incomplete.  Please read the error message(s).");
        return false;
    }
    else {
        //alert("The form was submitted succesfully!");
        return true;
    }
};
</script>

</head>
<body bgcolor=skyblue>
<center>
<img style="width: 976px; height: 281px;" src="<%= request.getContextPath()%>/Img/Logo.jpg"/>

<br><br>Sign Up your Account!!

		<br><br><form action="CreateAccountControll" method="post" onsubmit="return validateData(this);" >
        <center>
        <table >
		<tbody>
			<tr >
			<td bgcolor="#c8d8f8" style="width: 188px;">Username (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 361px"><input type="text" name="username" size="20" style="width: 329px; "><td style="width: 184px; ">
			<div id="usernameMsg" style="display:none;"><span style="color:red;">* Please fill Username.</span></div>
			</tr>
			<!--tr>
			<td bgcolor="#c8d8f8" style="width: 188px;">Password (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="password" name="password" size="20" style="width: 329px; "><td style="width: 212px; ">
			<div id="passMsg" style="display:none;"><span style="color:red;">* Your pass is not correct.</span></div>
			</tr>
			<tr>
			<td bgcolor="#c8d8f8" style="width: 188px;">Confirm Password (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="password" name="confpassword" size="20" style="width: 329px; "></td>
			</tr-->
			<tr>
			<td bgcolor="#c8d8f8" style="width: 188px;">Firstname (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="text" name="firstname" size="20" style="width: 329px; "><td style="width: 212px; ">
			<div id="firstnameMsg" style="display:none;"><span style="color:red;">* Please fill your Firstname.</span></div>
			</tr>
			<tr>
			<td bgcolor="#c8d8f8" style="width: 188px;">Lastname (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="text" name="lastname" size="20" style="width: 329px; "><td style="width: 212px; ">
			<div id="lastnameMsg" style="display:none;"><span style="color:red;">* Please fill your Lastname.</span></div>
			</tr>
			<tr>
			<td bgcolor="#c8d8f8" style="width: 188px;">Telephone (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="text" name="telephone" size="20" style="width: 329px; "><td style="width: 184px; ">
			<div id="teleMsg" style="display:none;"><span style="color:red;">* Please fill Telephone.</span></div>
			</tr>
			<tr style="height: 47px; ">
			<td bgcolor="#c8d8f8" style="width: 188px;">Email (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="text" name="email" size="20" style="width: 329px; " placeholder="example@gmail.gr"><td style="width: 184px; ">
			<div id="emailMsg" style="display:none;"><span style="color:red;">* Please fill correct E-mail.</span></div>
			</tr>
			<tr>
			<td bgcolor="#c8d8f8">Address street (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><textarea rows="2" cols="20" name="addrstreet" style="width: 329px; "></textarea><td style="width: 184px; ">
			<div id="addrStreetMsg" style="display:none;"><span style="color:red;">* Please fill Address street.</span></div>
			</tr>
			<tr>
			<td bgcolor="#c8d8f8">Address Number (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="text" name="addrnumber" size="20" style="width: 329px; "><td style="width: 223px; ">
			<div id="addrNumMsg" style="display:none;"><span style="color:red;">* Please fill Address Number.</span></div>
			</tr>
			<tr>
			<td bgcolor="#c8d8f8">ZipCode</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="text" name="zipcode" size="20" style="width: 329px; "></td>
			</tr>
			<tr>
			<td bgcolor="#c8d8f8">City (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="text" name="city" size="20" style="width: 329px; "><td style="width: 184px; ">
			<div id="cityMsg" style="display:none;"><span style="color:red;">* Please fill City.</span></div>
			</tr>
			<tr>
			<td bgcolor="#c8d8f8">Country (*)</td>
			<td bgcolor="#c8d8f8">:</td>
			<td bgcolor="#c8d8f8" style="height: 20px; width: 193px"><input type="text" name="country" size="20" style="width: 329px; "><td style="width: 184px; ">
			<div id="countryMsg" style="display:none;"><span style="color:red;">* Please fill Country.</span></div>
			</tr>
			<tr>
			
			<td></td>
			<td></td>
			<td></td>
			</tr>
			<tr>
			<td></td>
			<td></td>
			<td><center><input type="submit" name="SignUp" value="Sign Up" style="height: 55px; width: 170px; "> </center>
			</tr>
</tbody>
</table>
</center>
		</form>
	</body>

</html>

