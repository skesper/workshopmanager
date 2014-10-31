/*
 *  31.10.2014 (C) KV RLP
 */
package de.kesper.workshopmanager.beans.order;

import de.kesper.persistence.model.Addressing;
import de.kesper.persistence.model.Car;
import de.kesper.persistence.model.Customer;
import de.kesper.persistence.model.OrderSet;
import de.kesper.persistence.model.WorkItem;
import de.kesper.workshop.tools.StringUtils;
import de.kesper.workshopmanager.utils.NavigationUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.annotation.PostConstruct;
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
public class OrderBean implements Serializable {
    
    @Inject
    private Conversation conversation;
    
    private OrderSet orderSet;
    private List<WorkItem> workItems;

    
    public OrderSet getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(OrderSet orderSet) {
        this.orderSet = orderSet;
    }

    public List<WorkItem> getWorkItems() {
        return workItems;
    }

    public void setWorkItems(List<WorkItem> workItems) {
        this.workItems = workItems;
    }
    
    public String customerToString() {
        Customer customer = orderSet.getCustomer();
        return StringUtils.customerToString(customer);
    }
    
    public String carToString() {
        Car car = orderSet.getCar();
        return StringUtils.carToString(car);
    }
    
    public double price(WorkItem wi) {
        if (wi.getDiscountedPrice()>0.) {
            return wi.getDiscountedPrice();
        }
        return wi.getPricePerUnit()*wi.getUnits()*(1.+wi.getTax());
    }
    
    public void doSave() {
        System.out.println("DEBUG: in doSave() - orderBean");
    }
    
    public String doNewOrder() {
        testData();
        return NavigationUtils.ORDER_EDIT;
    }
    
    private void testData() {
        Customer owner = new Customer();
        owner.setAddressing(Addressing.MALE);
        owner.setFamilyName("Kesper");
        owner.setFirstName("Stephan");
        owner.setStreet("Kiefernweg 2");
        owner.setZipCode(56075);
        owner.setCity("Koblenz");
                
        Car car = new Car();
        car.setModel("530d");
        car.setVendor("BMW");
        car.setOwner(owner);
        car.setRegCity("KO");
        car.setRegLetters("MM");
        car.setRegDigits("123");
        car.setVin("W0512341234123412341234");
        
        orderSet = new OrderSet();
        orderSet.setCar(car);
        orderSet.setCustomer(owner);
        orderSet.setDueDate(new Date());
        
        workItems = new ArrayList<>();
        
        WorkItem wi;
        
        wi = new WorkItem();
        wi.setName("Ölwechsel");
        wi.setOrderSet(orderSet);
        wi.setPricePerUnit(35.);
        wi.setTax(0.19);
        wi.setUnits(1.);
        workItems.add(wi);
        
        wi = new WorkItem();
        wi.setName("Vergaser");
        wi.setOrderSet(orderSet);
        wi.setPricePerUnit(250.);
        wi.setTax(0.19);
        wi.setUnits(1.);
        workItems.add(wi);
        
        wi = new WorkItem();
        wi.setName("Arbeitsstunden");
        wi.setOrderSet(orderSet);
        wi.setPricePerUnit(25.);
        wi.setTax(0.19);
        wi.setUnits(5.5);
        workItems.add(wi);
        
    }
}
