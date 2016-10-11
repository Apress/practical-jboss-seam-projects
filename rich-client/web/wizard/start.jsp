<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Start"/>
    <ui:define name="main">
    <f:view>
        <h:form>
            <table border="0">
                <tr>
                    <td class="formLabel">Name:</td>
                    <td>
                        <h:inputText value="#{gadget.name}"
                                     style="formInput"/>
                    </td>
                </tr>
                <tr>
                    <td class="formLabel">Description:</td>
                    <td>
                        <h:inputText value="#{gadget.description}"
                                     style="formInput"/>
                    </td>
                </tr>
            </table>
            <h:commandButton value="Cancel" action="cancel"/>
            <h:commandButton value="Next" action="next"/>
        </h:form>
    </f:view>
    </ui:define>
</ui:composition>
</html>
