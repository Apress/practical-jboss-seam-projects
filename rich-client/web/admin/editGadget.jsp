<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Edit Gadget '#{gadget.name}'"/>
    <ui:define name="main">
    <f:view>
        <h:form>
            <table border="0">
                <tr>
                    <td class="formLabel">Name:</td>
                    <td>
                        <h:inputText value="#{gadget.name}"
                                     required="true" 
                                     style="formInput"/>
                    </td>
                </tr>
                <tr>
                    <td class="formLabel">Description:</td>
                    <td>
                        <h:inputText value="#{gadget.description}"
                                     required="true" 
                                     style="formInput"/>
                    </td>
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
                        <!-- Link to add a new gadget type -->
                        <br/>
                        <s:link view="/editGadgetTypes.seam">
                            <h:outputText value="Add/remove gadget types"/>
                        </s:link>
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
                        <!-- Link to add a new gadget type -->
                        <br/>
                        <s:link view="/editGadgetFeatures.seam">
                            <h:outputText value="Add/remove gadget features"/>
                        </s:link>
                    </td>
                </tr>
            </table>
            <h:commandButton rendered="#{empty gadgetMatches}"
                             type="submit" value="Finished"
                             action="#{gadgetAdmin.saveGadget}"/>
            <h:commandButton rendered="#{!empty gadgetMatches}"
                             type="submit" value="Back to list"                          
                             action="#{gadgetAdmin.listGadgets}"/>
        </h:form>
    </f:view>
    </ui:define>
</ui:composition>
</html>
