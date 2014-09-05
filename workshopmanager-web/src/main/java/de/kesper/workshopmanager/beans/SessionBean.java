/*
 *  03.09.2014 (C) KV RLP
 */

package de.kesper.workshopmanager.beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author kesper
 */
@Named
@SessionScoped
public class SessionBean implements Serializable {

    private String version = "v1.0";
    
    private float valueAddedTax = 19.F;

    public float getValueAddedTax() {
        return valueAddedTax;
    }

    public void setValueAddedTax(float valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
