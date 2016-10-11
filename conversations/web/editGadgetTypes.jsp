<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Adjust Gadget Types</title>
    <link href="styles.css" rel="stylesheet" type="text/css">
</head>

<body>
    <f:view>
        <h2>Setting types for gadget &quot;<h:outputText value="#{gadget.name}"/>&quot;</h2>
        <table border="0">
            <tr>
                <td>
                    <h:form>
                        <table border="0">
                            <tr><td>Select types for this gadget:</td>
                            <tr>
                                <td>
                                    <h:selectManyCheckbox 
                                            value="#{gadget.types}"
                                            converter="#{gadgetTypeList.converter}"
                                            required="true"
                                            layout="pageDirection">
                                        <f:selectItems value="#{gadgetTypeList.allTypes}" />
                                    </h:selectManyCheckbox> 
                                </td>
                            </tr>
                        </table>
                        <h:commandButton type="submit" value="Set"
                                         action="#{gadgetAdmin.doneEdit}"/>
                    </h:form>
                </td>
                <td>
                    <h:form>
                        <table border="0">
                            <tr><td colspan="2">Create a new gadget type:</td></tr>
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
                                         action="#{gadgetAdmin.saveGadgetType}"/>
                    </h:form>
                </td>
            </tr>
        </table>
    </f:view>
</body>
</html>
