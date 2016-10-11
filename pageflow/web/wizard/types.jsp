<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>New Gadget Wizard: Add Types</title>
    <link href="../styles.css" rel="stylesheet" type="text/css">
</head>

<body>
    <%@ include file="../header.jsp" %>
    <f:view>
        <h:messages layout="table"
                    infoClass="infoMessage" 
                    errorClass="errorMessage"/>
        <br/>
        <h2>Setting types for gadget &quot;<h:outputText value="#{gadget.name}"/>&quot;</h2>
        <h:form>
            <table border="0">
                <tr><td>Select types for this gadget:</td></tr>
                <tr>
                    <td>
                        <h:selectManyCheckbox 
                                value="#{gadget.types}"
                                converter="#{gadgetTypeList.converter}"
                                layout="pageDirection">
                            <f:selectItems value="#{gadgetTypeList.allTypes}" />
                        </h:selectManyCheckbox> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <h:commandButton value="New Types" action="new"/>
                    </td>
                </tr>
            </table>
            <h:commandButton value="Prev" action="prev"/>
            <h:commandButton value="Next" action="next"/>
        </h:form>
    </f:view>
    <%@ include file="../footer.jsp" %> 
</body>
</html>
