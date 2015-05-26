<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--link rel="stylesheet" type="text/css" href="resources/customerStyle.css" /-->
<title>Welcome in Playroom</title>
	<script type="text/javascript">
	function validateRentData(form)
	{	
	try{
		var quant = parseInt(form.itemsfield.value,10);
		var date = form.datefield.value;
		
		var max = document.getElementById("RentGame")[document.getElementById("RentGame").selectedIndex].value;
		//alert(quant+"--"+max+"--");
		var array = max.split('-');
		max = parseInt(array[0]);

		var success = 1;
		
	    if (!quant || quant>max) {
	        document.getElementById("itemserrorMsg").style.display = "block";
	        form.itemsfield.style.backgroundColor = "yellow";
	        form.itemsfield.style.border = "3px red solid";
	        success = 0;
	    }	
		else {
	        form.itemsfield.style.backgroundColor = "";
	        form.itemsfield.style.border = "";
	        document.getElementById("itemserrorMsg").style.display = "none";
	    }
	    
	    if (!date ) {
	        document.getElementById("dateemptyMsg").style.display = "block";
	        form.datefield.style.backgroundColor = "yellow";
	        form.datefield.style.border = "3px red solid";
	        success = 0;
	    }	
		else {
	        form.datefield.style.backgroundColor = "";
	        form.datefield.style.border = "";
	        document.getElementById("dateemptyMsg").style.display = "none";
	    }
	    
	    if(success==0) {
	    
	        alert("The form has wrong input fields!!");
	        return false;
	    }
	    else {
	        //alert("The form was submitted succesfully!");
	        return true;
	    }
	    }catch(obj){}
	};
	</script>
</head>
<body>
<center>
	<img style="width: 976px; height: 281px;" src="<%= request.getContextPath()%>/Img/Logo.jpg"/><br>
	Welcome <%= request.getAttribute("user")%> !!
	<form action="LoginControll" method="GET"  >
		<button type="submit" style="height: 26px; ">Log Out</button>
	</form>
	
	</center> 
	<h3 style="height: 23px; background: skyblue;">Make a Rent</h3>
	
	<form action="CreateRentControll" method="post" onsubmit="return validateRentData(this);" style="height: 165px; width: 767px">	
        <table >
		<tbody>
			<tr >
				<td align = "center" bgcolor="skyblue" style="width: 188px;"><select id = "RentGame" name="RentGame" onchange="showItems(this.value)" style="height: 32px; ">  
			    <option value="none">Select a Game for Rent</option>  
			     <%
			         try
			         {
			             Class.forName("com.mysql.jdbc.Driver").newInstance();  
			             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/playroomweb","root","");  
			             Statement stmt = con.createStatement();  
			             //ResultSet rs = stmt.executeQuery("select title,id from games");
			             ResultSet rs = stmt.executeQuery("SELECT count(i.id),g.title FROM `items` as i inner join `games` as g on g.id = i.gameno where i.isAvailable=1 group by g.title");
			             while(rs.next())
			             {
						     %>
						     <option id="idmax" VALUE="<%=rs.getString(1)+"-"+rs.getString(2)%>"><%=rs.getString(2)%></option> 
						     <%
			             }
			             
			             stmt.close();
			             con.close();
			             
			         }
			         catch (Exception e)
			         {
			             System.err.println("Generic Exception: " + e.getMessage());
			         }      
			      %>
			
			      </select>
			      <script type="text/javascript">
				    function showItems(sel) {
				    	var array = sel.split('-');
				       	alert("Max items for Rent: "+array[0]);
				    }
				</script> 
			    </td>
				<td align = "center" bgcolor="skyblue" style="width: 193px; ">
			    		<input name="datefield" placeholder="YYYY-MM-DD hh:mm:ss" style="height: 28px; width: 182px">
			    		<div id="dateemptyMsg" style="display:none;"><span style="color:red;">* Fill Date!!</span></div>
			    </td>
				<td align = "center" bgcolor="skyblue" style="width: 193px; height: 57px">
				    	<input name="itemsfield" placeholder="items" style="height: 28px; width: 82px">
				    	<div id="itemserrorMsg" style="display:none;"><span style="color:red;">* Items error!!</span></div>
				</td>
			</tr>
			
			<tr>
				<td></td>
				<td><center><input type="submit" name="Rent" value="Ok" style="width: 75px; height: 32px"> </center></td>
				<td></td>
			</tr>
	</tbody>
	</table>
	</form>
		
	<h3 style="height: 23px; background: skyblue;">Personal Infos</h3>
	
	<form action="CustomerMgmControll" method="post" style="height: 251px; width: 253px">
			<div style="width: 436px; ">
	        UserName:<br>
	        <input name="userfield" value=<%= request.getAttribute("username")%> style="width: 242px; "><br>
	        Password:<br>
	        <input name="passfield" value=<%= request.getAttribute("password")%> style="width: 242px; "><br>
	        Phone Number:<br>
	        <input name="telefield" value=<%= request.getAttribute("telephone")%> style="width: 242px; "><br>
	        Email:<br>
	        <input name="mailfield" value=<%= request.getAttribute("email")%> style="width: 242px; "><br>
	        <input type=hidden name="id" value=<%= request.getAttribute("id")%>>
			<input type="submit" value="Update">
	        </div>
	</form>
	<hr style="height: 23px; background: skyblue;">

	<br>
</body>
</html>