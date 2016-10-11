<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>New Gadget Wizard: Confirm New Gadget #{gadget.name}</title>
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
                <tr><td colspan="2">Please confirm your new gadget's details:</td></tr>
                <tr>
                    <td class="formLabel">Name:</td>
                    <td><h:outputText styleClass="dataText"
                                      value="#{gadget.name}"/></td>
                </tr>
                <tr>
                    <td class="formLabel">Description:</td>
                    <td><h:outputText styleClass="dataText" 
                                      value="#{gadget.description}"/></td>
                </tr>
                <tr>
                    <td class="formLabel">Types:</td>
                    <td>
                        <h:outputText rendered="#{empty gadget.types}"
                                      value="No types assigned"/>
                        <h:dataTable value="#{gadget.types}" var="t"
                                     styleClass="datatable" 
                                     columnClasses="dataCell"
                                     rendered="#{!empty gadget.types}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Label" />
                                </f:facet>
                                <h:outputText value="#{t.label}" />
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Description" />
                                </f:facet>
                                <h:outputText value="#{t.description}" />
                            </h:column>
                        </h:dataTable>
                    </td>
                </tr>
                <tr>
                    <td class="formLabel">Features:</td>
                    <td>
                        <h:outputText rendered="#{empty gadget.features}"
                                      value="No types assigned"/>
                        <h:dataTable value="#{gadget.features}" var="f"
                                     styleClass="datatable" 
                                     columnClasses="dataCell"
                                     rendered="#{!empty gadget.features}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Label" />
                                </f:facet>
                                <h:outputText value="#{f.label}" />
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Description" />
                                </f:facet>
                                <h:outputText value="#{f.description}" />
                            </h:column>
                        </h:dataTable>
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
