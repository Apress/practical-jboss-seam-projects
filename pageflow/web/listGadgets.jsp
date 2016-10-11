<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Gadget List</title>
    <link href="styles.css" rel="stylesheet" type="text/css">
</head>

<body>
    <%@ include file="header.jsp" %> 
    <f:view>
        <h:messages/>
        <!--  Show the matching gadgets, if any -->
        <h:outputText rendered="#{empty gadgetMatches}" 
                      value="No matching gadgets found."/>
        <h:dataTable rendered="#{!empty gadgetMatches}"
                     value="#{gadgetMatches}" var="selGadget"
                     columnClasses="dataCell">
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Name" />
                </f:facet>
                <h:outputText value="#{selGadget.name}" />
            </h:column>
            
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Description" />
                </f:facet>
                <h:outputText value="#{selGadget.description}" />
            </h:column>
            <h:column>
                <f:facet name="header">
                    <h:outputText value="Type(s)"/>
                </f:facet>
                <h:outputText rendered="#{empty selGadget.types}"
                              value="No types assigned"/>
                <h:dataTable rendered="#{!empty selGadget.types}"
                             value="#{selGadget.types}" var="t">
                    <h:column>
                        <h:outputText value="#{t.label}" />
                    </h:column>
                </h:dataTable>
            </h:column>
            <h:column>
                <s:button value="Edit" 
                          action="#{gadgetAdmin.editGadget}" />
            </h:column>
        </h:dataTable>
        <h:form>
            <!-- Finish with these search results, end this conversation -->
            <s:link view="/adminHome.seam" propagation="end">
            	<h:outputText value="Done"/>
           	</s:link>
        </h:form>
    </f:view>
    <%@ include file="footer.jsp" %> 
</body>
</html>

