<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Search Results"/>
    <ui:define name="main">
    <f:view>
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
            <s:link view="/admin/adminHome.seam" propagation="end">
            	<h:outputText value="Done"/>
           	</s:link>
        </h:form>
    </f:view>
    </ui:define>
</ui:composition>
</html>

