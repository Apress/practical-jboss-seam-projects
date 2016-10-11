<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Gadget List</title>
</head>

<body>
    <f:view>
        <h:messages/>
        <!--  Show the current gadget catalog -->
        <h:dataTable value="#{gadgetAdmin.allGadgets}" var="g">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Type" />
                </f:facet>
                <h:outputText value="#{g.type.label}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Description" />
                </f:facet>
                <h:outputText value="#{g.description}" />
            </h:column>
        </h:dataTable>
        <h:form>
            <!-- Link to add a new gadget -->
            <s:link action="addGadget">
            	<h:outputText value="[Add a new gadget]"/>
           	</s:link>
        </h:form>
    </f:view>
</body>
</html>

