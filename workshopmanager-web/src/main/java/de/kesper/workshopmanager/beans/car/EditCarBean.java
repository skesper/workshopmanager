/*
 *  04.09.2014 (C) Stephan Kesper
 */

package de.kesper.workshopmanager.beans.car;

import de.kesper.persistence.model.Car;
import de.kesper.workshop.tools.StringUtils;
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
public class EditCarBean implements Serializable {
    
    @Inject
    private Conversation conversation;

    private Car car;
    
    private String kzCity;
    private String kzLetter;
    private String kzDigits;

    public String getKzCity() {
        return kzCity;
    }

    public void setKzCity(String kzCity) {
        this.kzCity = kzCity;
    }

    public String getKzLetter() {
        return kzLetter;
    }

    public void setKzLetter(String kzLetter) {
        this.kzLetter = kzLetter;
    }

    public String getKzDigits() {
        return kzDigits;
    }

    public void setKzDigits(String kzDigits) {
        this.kzDigits = kzDigits;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public String doEdit(Car car) {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        this.car = car;
        return NavigationUtils.CAR_EDIT;
    }
    
    public String doNewCar() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        this.car = new Car();
        return NavigationUtils.CAR_EDIT;
    }
    
    public void doSave() {
        System.out.println("DEBUG: in doSave");
    }
}
