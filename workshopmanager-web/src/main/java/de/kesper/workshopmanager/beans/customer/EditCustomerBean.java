/*
 *  30.10.2014 (C) Stephan Kesper
 */
package de.kesper.workshopmanager.beans.customer;

import de.kesper.persistence.model.Customer;
import de.kesper.workshopmanager.utils.JsfUtil;
import de.kesper.workshopmanager.utils.NavigationUtils;
import java.io.Serializable;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author kesper
 */
@Named
@ConversationScoped
public class EditCustomerBean implements Serializable {
    private Customer customer;
    
    @Inject
    private Conversation conversation;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public String doEditCustomer(Customer customer) {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        this.customer = customer;
        return NavigationUtils.CUSTOMER_EDIT;
    }
    
    public String doNewCustomer() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        this.customer = new Customer();
        return NavigationUtils.CUSTOMER_EDIT;
    }
    
    public void doSave() {
        System.out.println("DEBUG: in doSave() - customer");
        
        JsfUtil.createWarnMessage(null, "doSave() noch nicht implementiert.");
    }
}
