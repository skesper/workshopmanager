/*
 *  03.09.2014 (C) Stephan Kesper
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
import javax.persistence.Transient;

/**
 *
 * @author kesper
 */
@Entity
public class Car implements Serializable {
    private Long id;
    private String vendor;
    private String vendorKey;
    private String model;
    private String modelKey;
    private String regCity;
    private String regLetters;
    private String regDigits;
    private String vin;
    private Date tuvDate;
    private Customer owner;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 75, nullable = true)
    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Column(length = 20, nullable = true)
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Column(length = 5, nullable = true)
    public String getRegCity() {
        return regCity;
    }

    public void setRegCity(String regCity) {
        this.regCity = regCity;
    }

    @Column(length = 5, nullable = true)
    public String getRegLetters() {
        return regLetters;
    }

    public void setRegLetters(String regLetters) {
        this.regLetters = regLetters;
    }

    @Column(length = 10, nullable = true)
    public String getRegDigits() {
        return regDigits;
    }

    public void setRegDigits(String regDigits) {
        this.regDigits = regDigits;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Column(nullable = true)
    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    @Column(length = 10, nullable = true)
    public String getVendorKey() {
        return vendorKey;
    }

    public void setVendorKey(String vendorKey) {
        this.vendorKey = vendorKey;
    }

    @Column(length = 50, nullable = true)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(length = 10, nullable = true)
    public String getModelKey() {
        return modelKey;
    }

    public void setModelKey(String modelKey) {
        this.modelKey = modelKey;
    }

    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    public Date getTuvDate() {
        return tuvDate;
    }

    public void setTuvDate(Date tuvDate) {
        this.tuvDate = tuvDate;
    }
    
    public String toRegistrationNumber() {
        
        return n(regCity).concat("-").concat(n(regLetters)).concat(" ").concat(n(regDigits));
    }
    
    private String n(String n) {
        if (n==null) return "";
        return n;
    }
}
