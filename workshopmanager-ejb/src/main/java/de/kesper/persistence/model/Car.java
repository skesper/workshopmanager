/*
 *  03.09.2014 (C) KV RLP
 */

package de.kesper.persistence.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kesper
 */
@Entity
public class Car implements Serializable {
    private Long id;
    private String type;
    private String vendorKey;
    private String model;
    private String modelKey;
    private String registrationNumber;
    private Date tuvDate;
    private Customer customer;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Column(length = 10)
    public String getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(String vendorKey) {
        this.vendorKey = vendorKey;
    }

    @Column(length = 50)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(length = 10)
    public String getModelKey() {
        return modelKey;
    }

    public void setModelKey(String modelKey) {
        this.modelKey = modelKey;
    }

    @Temporal(TemporalType.DATE)
    public Date getTuvDate() {
        return tuvDate;
    }

    public void setTuvDate(Date tuvDate) {
        this.tuvDate = tuvDate;
    }
}
