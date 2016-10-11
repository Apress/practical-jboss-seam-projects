<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:ui="http://java.sun.com/jsf/facelets"
    xmlns:s="http://jboss.com/products/seam/taglib"
    xmlns:h="http://java.sun.com/jsf/html"
    xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Administration Home"/>
    
    <ui:define name="bodyScripts">
        <!--  Import the JavaScript remote interface for our GadgetAdmin bean -->
        <script type="text/javascript" src="../seam/resource/remoting/interface.js?gadgetAdmin"></script>
        
        <script type="text/javascript">
            //  A function that defines a data source for the gadget auto-complete.
            //  This function is set as the onLoad event for the body (see above)
            function onPageLoad() {
                var gadgetAdmin = Seam.Component.getInstance("gadgetAdmin");
                gadgetDS =
                    new DS_SeamRemoting(gadgetAdmin, "search", null);
            };
            
            // Create an auto-complete widget for the company name field below
            initGadgetAC = function() {
                var gadgetAC;
                return {
                    init : function() {
                        var searchBox = findObjectById("gadgetSearchBox");
                        var searchField = findObjectByTagName(searchBox, "input");
                        gadgetAC = 
                            new YAHOO.widget.AutoComplete(searchField.id, 'gadgetMatches', gadgetDS);                                           
                        gadgetAC.formatResult = 
                            function(oResultItem, sQuery) {
                                var sMarkup = oResultItem.getName();
                                return (sMarkup);
                            };
                    }
                }
            }();
            
            YAHOO.util.Event.addListener(this,"load",initGadgetAC.init);
        </script>
    </ui:define>
    
    <ui:define name="main">
    
    <f:view>
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
                        <div id="gadgetSearchBox">
                            <h:inputText value="#{gadgetAdmin.searchField}"/>
                        </div>
                        <div id="gadgetMatches"></div>
                    </td>
                    <td>
                        <h:commandLink type="submit" value="Search"
                                       action="#{gadgetAdmin.search}">
                            <f:param name="conversationPropagation" value="begin"/>
                        </h:commandLink>
                    </td>
                </tr>
            </table>
            <s:link action="#{gadgetAdmin.newGadget}" value="Add a new gadget"/>
        </h:form>
        <br/>
        <table>
            <tr>
                <td class="formLabel">Tasks assigned to you:</td>
                <td class="formLabel">Tasks you can accept:</td>
            </tr>
            <tr>
                <td valign="top">
                    <h:dataTable rendered="#{not empty taskInstanceList}"
                                 value="#{taskInstanceList}"
                                 var="task">
                        <h:column>
                            <f:facet name="header">Description</f:facet>
                            <h:outputText value="#{task.description}"/>
                        </h:column>
                        <h:column>
                            <s:link action="#{gadgetReview.startReviewTask}" 
                                    value="Begin" taskInstance="#{task}"/>
                        </h:column>
                    </h:dataTable>
                </td>
                <td valign="top">
                    <h:dataTable rendered="#{not empty pooledTaskInstanceList}"
                                 value="#{pooledTaskInstanceList}"
                                 var="task">
                        <h:column>
                            <f:facet name="header">Description</f:facet>
                            <h:outputText value="#{task.description}"/>
                        </h:column>
                        <h:column>
                            <s:link action="#{pooledTask.assignToCurrentActor}" 
                                    value="Accept" taskInstance="#{task}"/>
                        </h:column>
                    </h:dataTable>
                </td>
            </tr>
        </table>
    </f:view>
    </ui:define>
</ui:composition>
</html>

