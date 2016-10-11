<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Login"/>
    <ui:define name="main">
        <f:view>
            <h:form>
                <table border="0">
                    <tr>
                        <td class="formLabel">User name:</td>
                        <td>
                            <h:inputText value="#{identity.username}"
                                         id="name" 
                                         style="formInput"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="formLabel">Password:</td>
                        <td>
                            <h:inputSecret value="#{identity.password}"
                                           id="password" 
                                           style="formInput"/>
                        </td>
                    </tr>
                </table>
                <h:commandButton value="Login"
                                 action="#{identity.login}"/>
            </h:form>
        </f:view>
    </ui:define>
</ui:composition>
</html>
