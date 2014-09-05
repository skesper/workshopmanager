/*
 *  04.09.2014 (C) KV RLP
 */

package de.kesper.workshopmanager.beans.car;

import de.kesper.persistence.model.Car;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author kesper
 */
@Named
@ViewScoped
public class EditCarBean implements Serializable {

    private Car car = new Car();

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    public void doSave() {
        System.out.println("DEBUG: in doSave");
    }
}
