<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>User Administration Home</title>
    <link href="../styles.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <f:view>
        <center><h3>User Administration Home (JSF navigation)</h3></center>
        <s:link action="#{userAdmin.newUser}">
        	<h:outputText value="Add a new user"/>
       	</s:link>
    </f:view> 
</body>
</html>

