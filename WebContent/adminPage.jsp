<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" 
xmlns:f="http://java.sun.com/jsf/core" 
xmlns:h="http://java.sun.com/jsf/html" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="resources/RentTableStyle.css" />
<title>System Administrator Page</title>
</head>
<body>
<f:view>
<center>
<img style="width: 976px; height: 281px;" src="<%= request.getContextPath()%>/Img/Logo2.png"/><br>
Welcome Administrator!!
<form action="LoginControll" method="GET"  >
		<button type="submit" style="height: 26px; ">Log Out</button>
</form>
</center>
<h:form id="form" style="height: 295px; "  >
<h3 style="height: 23px; background: skyblue;">Open Rents</h3>
	<h:dataTable border="1" 
	id = "RentsTable"
	value="#{rentBeans.tempListFournisseurs}" 
	var="o" 
	styleClass="Rent-table" 
	headerClass="Rent-table-header" 
	rowClasses="Rent-table-odd-row,Rent-table-even-row" style="width: 816px; ">
		<h:column id="column1">
			<f:facet name="header">
				<h:outputText value="FirstName"></h:outputText>
			</f:facet>
			<h:outputText value="#{o.firstName}"/>
		</h:column>
		<h:column id="column2">
			<f:facet name="header">
				<h:outputText value="LastName"></h:outputText>
			</f:facet>
			<h:outputText value="#{o.lastName}"/>
		</h:column>
		<h:column id="column3">
			<f:facet name="header">
				<h:outputText value="Customer Code"></h:outputText>
			</f:facet>
			<h:outputText value="#{o.customerCode}"></h:outputText>
		</h:column>
		<h:column id="column4">
			<f:facet name="header">
				<h:outputText value="Game Title"></h:outputText>
			</f:facet>
			<h:outputText value="#{o.title}"></h:outputText>
		</h:column>
		<h:column id="column5">
			<f:facet name="header">
				<h:outputText value="Serial Number"></h:outputText>
			</f:facet>
			<h:outputText value="#{o.serialNumOfItem}"></h:outputText>
		</h:column>
		<h:column id="column6">
			<f:facet name="header">
				<h:outputText value="State Of Item"></h:outputText>
			</f:facet>
			<h:outputText value="#{o.stateOfItem}"></h:outputText>
		</h:column>
		<h:column id="column7">
			<f:facet name="header">
				<h:outputText value="Date from"></h:outputText>
			</f:facet>
			<h:outputText value="#{o.fromDate}"></h:outputText>
		</h:column>
		<h:column id="column8">
			<f:facet name="header">
				<h:outputText value="Return Code"></h:outputText>
			</f:facet>
			<h:outputText value="#{o.returnCode}"></h:outputText>
		</h:column>
	</h:dataTable><br>
	<h:form id="return">
		<h:inputText id="input" value="#{returnBeans.returnCode}"/>
		<h:commandButton value = "Return" action = "#{returnBeans.returnRent() }" >
		</h:commandButton>
	</h:form>
			<%-- <form>
				<input>
				<input type="submit">
			</form> --%>
		</h:form>
</f:view>
</body>
</html>