<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.0 Transitional//EN" 
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:ui="http://java.sun.com/jsf/facelets"
      xmlns:s="http://jboss.com/products/seam/taglib"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
<ui:composition template="template.xhtml">
    <ui:param name="title" value="Choose Features"/>
    <ui:define name="main">
    <f:view>
        <h3>Reviewing features for gadget 
            &quot;<h:outputText value="#{reviewGadget.name}"/>&quot;</h3>
        <table border="0">
            <tr>
                <td>
                    <h:form>
                        <table border="0">
                            <tr><td>Select features for this gadget:</td></tr>
                            <tr>
                                <td>
                                    <h:selectManyCheckbox 
                                            value="#{reviewGadget.features}"
                                            converter="#{gadgetFeatureList.converter}"
                                            layout="pageDirection">
                                        <f:selectItems value="#{gadgetFeatureList.allFeatures}" />
                                    </h:selectManyCheckbox> 
                                </td>
                            </tr>
                        </table>
                        <h:commandButton type="submit" value="Confirm"
                                         action="#{gadgetReview.saveFeatureReviewData}"/>
                    </h:form>
                </td>
                <td>
                    <h:form>
                        <table border="0">
                            <tr><td colspan="2">Create a new gadget type:</td></tr>
                            <tr>
                                <td>Label:</td>
                                <td>
                                   <h:inputText value="#{gadgetFeature.label}"
                                                required="true" />
                                </td>
                         </tr>
                         <tr>
                                <td>Description:</td>
                                <td>
                                    <h:inputText value="#{gadgetFeature.description}"
                                                 required="true" />
                                </td>
                            </tr>
                        </table>
                        <h:commandButton type="submit" value="Create feature"
                                         action="#{gadgetAdmin.saveGadgetFeature}"/>
                    </h:form>
                </td>
            </tr>
        </table>
    </f:view>
    </ui:define>
</ui:composition>
</html>
