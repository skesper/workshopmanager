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

    private float valueAddedTax = 19.F;

    public float getValueAddedTax() {
        return valueAddedTax;
    }

    public void setValueAddedTax(float valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
    }
}
