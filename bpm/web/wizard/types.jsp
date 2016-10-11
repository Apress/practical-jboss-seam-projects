<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Choose Types"/>
    <ui:define name="main">
    <f:view>
        <h3>Setting types for gadget &quot;<h:outputText value="#{gadget.name}"/>&quot;</h3>
        <h:form>
            <table border="0">
                <tr><td>Select types for this gadget:</td></tr>
                <tr>
                    <td>
                        <h:selectManyCheckbox 
                                value="#{gadget.types}"
                                converter="#{gadgetTypeList.converter}"
                                layout="pageDirection">
                            <f:selectItems value="#{gadgetTypeList.allTypes}" />
                        </h:selectManyCheckbox> 
                    </td>
                </tr>
                <tr>
                    <td>
                        <h:commandButton value="New Types" action="new"/>
                    </td>
                </tr>
            </table>
            <h:commandButton value="Prev" action="prev"/>
            <h:commandButton value="Next" action="next"/>
        </h:form>
    </f:view>
    </ui:define>
</ui:composition>
</html>
