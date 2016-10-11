<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>

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
                                         required="true">
                            <f:selectItems value="#{gadgetAdmin.gadgetTypes}" />
                        </h:selectOneMenu>
                    </td>
                </tr>
            </table>
            <h:commandButton type="submit" value="Create"
                             action="#{gadgetAdmin.newGadget}" />
        </h:form>
    </f:view>
</body>
</html>
