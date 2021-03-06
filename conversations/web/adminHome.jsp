<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://jboss.com/products/seam/taglib" prefix="s" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Gadget Administration Home</title>
    <link href="styles.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <%@ include file="header.jsp" %> 
    <f:view>
        <h:messages/>
        <!--  Switch workspaces, if any exist -->
        <h:form rendered="#{!empty switcher.selectItems}">
            <h:commandButton action="#{switcher.select}" value="Jump to:"/>
            <h:selectOneMenu value="#{switcher.conversationIdOrOutcome}">
                <f:selectItems value="#{switcher.selectItems}"/>
            </h:selectOneMenu>
        </h:form>
        <!-- Link to add a new gadget -->
        <h:form>
            <table border="0">
                <tr>
                    <td class="formLabel">Find gadgets: </td>
                    <td class="formInput">
                        <h:inputText value="#{gadgetAdmin.searchField}"/>
                    </td>
                    <td>
                        <h:commandLink type="submit" value="Search"
                                       action="#{gadgetAdmin.search}">
                            <f:param name="conversationPropagation" value="begin"/>
                        </h:commandLink>
                    </td>
                </tr>
            </table>
        </h:form>
        <s:link action="#{gadgetAdmin.editGadget}">
        	<h:outputText value="Add a new gadget"/>
       	</s:link>
    </f:view>
    <%@ include file="footer.jsp" %> 
</body>
</html>

