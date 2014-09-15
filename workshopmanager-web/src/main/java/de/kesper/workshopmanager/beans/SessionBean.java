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

    private boolean authenticated = false;
    
    private String version = "v1.0";
    
    private float valueAddedTax = 19.F;
    
    private String userName;
    private String password;

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

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
    
    public String doLogin() {
        authenticated = true;
        return "OK";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
