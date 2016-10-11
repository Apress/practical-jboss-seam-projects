<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Add a User</title>
    <link href="../styles.css" rel="stylesheet" type="text/css">
</head>

<body>
    <f:view>
        <center><h3>Add a user (JSF navigation)</h3></center>
        <h:form>
            <table border="0">
                <tr>
                    <td class="formLabel">Name:</td>
                    <td>
                        <h:inputText value="" 
                                     style="formInput"/>
                    </td>
                </tr>
                <tr>
                    <td class="formLabel">Roles:</td>
                    <td>
                        <!-- Link to add a new role -->
                        <br/>
                        <s:link action="#{userAdmin.editRoles}">
                            <h:outputText value="Add a role to this user"/>
                        </s:link>
                    </td>
                </tr>
            </table>
            <h:commandButton value="Save" action="save"/>
        </h:form>
    </f:view>
</body>
</html>
