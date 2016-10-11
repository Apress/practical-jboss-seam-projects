<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Confirm New Gadget"/>
    <ui:define name="main">
    <f:view>
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
    </ui:define>
</ui:composition>
</html>
