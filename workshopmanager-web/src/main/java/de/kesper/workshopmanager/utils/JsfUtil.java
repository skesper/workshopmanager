/*
 *  30.10.2014 (C) KV RLP
 */
package de.kesper.workshopmanager.utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kesper
 */
public class JsfUtil {

    public static void createErrorMessage(String id, String description) {
        createMessage(FacesMessage.SEVERITY_ERROR, id, "FEHLER", description);
    }
    public static void createInfoMessage(String id, String description) {
        createMessage(FacesMessage.SEVERITY_INFO, id, "INFO", description);
    }
    public static void createWarnMessage(String id, String description) {
        createMessage(FacesMessage.SEVERITY_WARN, id, "WARNUNG", description);
    }
    public static void createFatalMessage(String id, String description) {
        createMessage(FacesMessage.SEVERITY_FATAL, id, "FATAL", description);
    }
    
    public static void createMessage(FacesMessage.Severity sev, String id, String messageType, String description) {
        FacesContext ctx = FacesContext.getCurrentInstance();
        if (ctx==null) {
            System.err.println("ERROR: Could not get Faces Context...");
            return;
        }
        FacesMessage msg = new FacesMessage(sev, messageType, description);
        System.out.println("DEBUG: createMessage("+sev+", "+id+", "+messageType+", "+description+")");
        ctx.addMessage(id, msg);
    }    
    
    public static HttpServletRequest getRequest() {
        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }
    
    public static HttpServletResponse getResponse() {
        return (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }
    
}
