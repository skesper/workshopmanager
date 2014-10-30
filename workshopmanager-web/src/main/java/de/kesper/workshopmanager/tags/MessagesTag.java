/*
 *  30.10.2014 (C) Stephan Kesper
 */
package de.kesper.workshopmanager.tags;

import java.io.IOException;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

/**
 *
 * @author kesper
 */
@FacesComponent(value = "de.kesper.workshopmanager.tags.MessagesTag")
public class MessagesTag extends UIOutput {

    private boolean globalOnly = false;

    public boolean isGlobalOnly() {
        return globalOnly;
    }

    public void setGlobalOnly(boolean globalOnly) {
        this.globalOnly = globalOnly;
    }

    @Override
    public String getFamily() {
        return "messages";
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        super.encodeEnd(context);
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        String forM = (String) this.getAttributes().get("for");
        String clazz = (String) this.getAttributes().get("styleClass");
        if (clazz != null && "".equals(clazz.trim())) {
            clazz = null;
        }

        Iterator<FacesMessage> msg;

        if (forM == null) {
            msg = globalOnly ? context.getMessages(null) : context.getMessages();
        } else {
            msg = globalOnly ? context.getMessages(null) : context.getMessages(forM);
        }

        if (msg != null) {
            while (msg.hasNext()) {
                FacesMessage fm = msg.next();
                if (fm.isRendered()) continue;
                fm.rendered();
                
                String severity = null;
                if (fm.getSeverity() != null) {
                    switch (fm.getSeverity().getOrdinal()) {
                        case (0): {
                            severity = "alert-info";
                        }
                        break;

                        case (1): {
                            severity = "alert-warning";
                        }
                        break;

                        case (2):
                        case (3): {
                            severity = "alert-danger";
                        }
                        break;
                    }
                }
                if (severity == null) {
                    severity = "alert-info";
                }

                writer.startElement("div", this);
                String style = clazz;
                if (style == null) {
                    style = "alert alert-dismissable ".concat(severity);
                } else {
                    style = style.concat(" ").concat("alert alert-dismissable ").concat(severity);
                }
                writer.writeAttribute("class", style, null);
                writer.startElement("button", this);
                writer.writeAttribute("type", "button", null);
                writer.writeAttribute("class", "close", null);
                writer.writeAttribute("data-dismiss", "alert", null);
                writer.writeAttribute("aria-hidden", "true", null);
                writer.write("&times;");
                writer.endElement("button");

                if (fm.getSummary() != null) {
                    if (!fm.getSummary().equals(fm.getDetail())) {
                        writer.startElement("strong", this);
                        writer.write(fm.getSummary());
                        writer.endElement("strong");
                    }
                }
                if (fm.getDetail() != null) {
                    writer.write(" ");
                    writer.write(fm.getDetail());
                }
                writer.endElement("div");
            }
        }
    }

}
