/*
 *  30.10.2014 (C) Stephan Kesper
 */
package de.kesper.workshop.tools;

import de.kesper.persistence.model.Car;
import de.kesper.persistence.model.Customer;

/**
 *
 * @author kesper
 */
public class StringUtils {
    public static boolean isEmpty(String s) {
        if (s==null) return true;
        return "".equals(s.trim());
    }
    
    public static String customerToString(Customer customer) {
        if (customer==null) return "n/a";
        return customer.getFamilyName()+", "+customer.getFirstName()+", "+customer.getStreet()+", "+customer.getZipCode()+" "+customer.getCity();
    }
    
    public static String carToString(Car car) {
        if (car==null) return "n/a";
        return car.getVendor()+", "+car.getModel()+", "+car.getRegCity()+"-"+car.getRegLetters()+" "+car.getRegDigits();
    }    
}
