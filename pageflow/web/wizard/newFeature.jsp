<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>New Gadget Wizard: New Feature</title>
    <link href="../styles.css" rel="stylesheet" type="text/css">
</head>

<body>
    <%@ include file="../header.jsp" %>
    <f:view>
        <h:messages layout="table"
                    infoClass="infoMessage" 
                    errorClass="errorMessage"/>
        <br/>
        <h:form>
            <table border="0">
                <tr><td colspan="2">Create a new gadget feature:</td></tr>
                <tr>
                    <td class="formLabel">Label:</td>
                    <td>
                       <h:inputText value="#{gadgetFeature.label}"
                                    style="formInput"/>
                    </td>
                 </tr>
                 <tr>
                    <td class="formLabel">Description:</td>
                    <td>
                        <h:inputText value="#{gadgetFeature.description}"
                                     style="formInput"/>
                    </td>
                </tr>
            </table>
            <h:commandButton value="Cancel" action="cancel"/>
            <h:commandButton value="Save" action="save"/>
        </h:form>
    </f:view>
    <%@ include file="../footer.jsp" %> 
</body>
</html>
