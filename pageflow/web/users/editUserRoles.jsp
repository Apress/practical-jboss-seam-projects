<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Edit user roles</title>
    <link href="../styles.css" rel="stylesheet" type="text/css">
</head>

<body>
    <f:view>
        <center><h3>Edit Roles (JSF navigation)</h3></center>
        <h:form>
            <table border="0">
                <tr>
                    <td class="formLabel">Role name:</td>
                    <td>
                        <h:inputText value="" 
                                     style="formInput"/>
                    </td>
                </tr>
            </table>
            <h:commandButton value="Save"
                             action="#{userAdmin.addRole}"/>
        </h:form>
    </f:view>
</body>
</html>
