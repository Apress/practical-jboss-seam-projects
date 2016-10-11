<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Add a Gadget Type</title>
</head>

<body>
    <f:view>
        <h:form>
            <table border="0">
                <tr>
                    <td>Label:</td>
                    <td>
                        <h:inputText value="#{gadgetType.label}"
                                     required="true" />
                    </td>
                </tr>
                <tr>
                    <td>Description:</td>
                    <td>
                        <h:inputText value="#{gadgetType.description}"
                                     required="true" />
                    </td>
                </tr>
            </table>
            <h:commandButton type="submit" value="Create"
                             action="#{gadgetAdmin.newGadgetType}" />
        </h:form>
    </f:view>
</body>
</html>
