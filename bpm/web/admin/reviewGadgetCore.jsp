<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:s="http://jboss.com/products/seam/taglib"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Edit Gadget '#{reviewTaskGadget.name}'"/>
    <ui:define name="main">
    <f:view>
        <h3>Reviewing core data for gadget 
            &quot;<h:outputText value="#{reviewGadget.name}"/>&quot;</h3>
        <h:form>
            <table border="0">
                <tr>
                    <td class="formLabel">Name:</td>
                    <td>
                        <h:inputText value="#{reviewGadget.name}"
                                     required="true" 
                                     style="formInput"/>
                    </td>
                </tr>
                <tr>
                    <td class="formLabel">Description:</td>
                    <td>
                        <h:inputText value="#{reviewGadget.description}"
                                     required="true" 
                                     style="formInput"/>
                    </td>
                </tr>
                <tr>
                    <td class="formLabel">Types:</td>
                    <td>
                        <h:outputText rendered="#{empty reviewGadget.types}"
                                      value="No types assigned"/>
                        <h:dataTable value="#{reviewGadget.types}" var="t"
                                     styleClass="datatable" 
                                     columnClasses="dataCell"
                                     rendered="#{!empty reviewGadget.types}">
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
                        <h:outputText rendered="#{empty reviewGadget.features}"
                                      value="No types assigned"/>
                        <h:dataTable value="#{reviewGadget.features}" var="f"
                                     styleClass="datatable" 
                                     columnClasses="dataCell"
                                     rendered="#{!empty reviewGadget.features}">
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
                <tr>
                    <td class="formLabel">Status:</td>
                    <td>
                        <h:selectOneMenu 
                            value="#{reviewGadget.status}"
                            converter="#{statusCodeList.converter}"
                            required="true">
                            <f:selectItems value="#{statusCodeList.allCodes}" />
                        </h:selectOneMenu> 
                    </td>
                </tr>
            </table>
            <h:commandButton type="submit" value="Confirm"
                             action="#{gadgetReview.saveCoreReviewData}"/>
        </h:form>
    </f:view>
    </ui:define>
</ui:composition>
</html>
