<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Add a Gadget</title>
</head>

<body>
    <f:view>
        <h:form>
            <table border="0">
                <tr>
                    <td>Description:</td>
                    <td>
                        <h:inputText value="#{gadget.description}"
                                     required="true" />
                    </td>
                </tr>
                <tr>
                    <td>Type:</td>
                    <td>
                        <h:selectOneMenu value="#{gadget.type}"
                                         converter="#{gadgetTypeList.converter}"
                                         required="true">
                            <f:selectItems value="#{gadgetTypeList.allTypes}" />
                        </h:selectOneMenu>
                        <!-- Link to add a new gadget type -->
                        <s:link action="addGadgetType">
                            <h:outputText value="[Add a new gadget type]"/>
                        </s:link>
                    </td>
                </tr>
            </table>
            <h:commandButton type="submit" value="Create"
                             action="#{gadgetAdmin.newGadget}" />
        </h:form>
    </f:view>
</body>
</html>
