/*
 *  04.09.2014 (C) KV RLP
 */

package de.kesper.workshopmanager.beans;

import de.kesper.persistence.model.Car;
import de.kesper.persistence.model.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author kesper
 */
@Named
@ViewScoped
public class StartPageBean implements Serializable {

    private String name;
    private String registrationNumber;
    private List<Customer> customerSearchResult;
    private List<Car> carSearchResult;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
    public void doSearch() {
        System.out.println("DEBUG: search - "+name+", "+registrationNumber);
        createTestData();
        //System.out.println("DEBUG: created "+customerSearchResult.size()+" customers.");
    }
    
    public void doReset() {
        customerSearchResult = null;
        carSearchResult = null;
        name = null;
        registrationNumber = null;
    }

    public List<Customer> getCustomerSearchResult() {
        return customerSearchResult;
    }

    public void setCustomerSearchResult(List<Customer> customerSearchResult) {
        this.customerSearchResult = customerSearchResult;
    }

    public List<Car> getCarSearchResult() {
        return carSearchResult;
    }

    public void setCarSearchResult(List<Car> carSearchResult) {
        this.carSearchResult = carSearchResult;
    }
    
    public boolean hasCarSearchResult() {
        return carSearchResult!=null && carSearchResult.size()>0;
    }
    
    public boolean hasCustomerSearchResult() {
        return customerSearchResult!=null && customerSearchResult.size()>0;
    }
    
    private void createTestData() {
        Customer c = new Customer();
        c.setCity("Koblenz");
        c.setFamilyName("Kesper");
        c.setFirstName("Stephan");
        c.setId(5L);
        c.setStreet("Kiefernweg 2");
        c.setZipCode(56075);
        customerSearchResult = new ArrayList<>();
        customerSearchResult.add(c);

        c = new Customer();
        c.setCity("Lahnstein");
        c.setFamilyName("Kessler");
        c.setFirstName("Peter");
        c.setId(6L);
        c.setStreet("Albertstraße 12a");
        c.setZipCode(56122);
        customerSearchResult.add(c);
        
        carSearchResult = new ArrayList<>();
        Car car = new Car();
        car.setModel("523 i");
        car.setVendor("BMW");
        car.setRegCity("KO");
        car.setRegLetters("MW");
        car.setRegDigits("551");
        car.setTuvDate(new Date());
        car.setVin("W0112345678910112");
        carSearchResult.add(car);
    }
}
