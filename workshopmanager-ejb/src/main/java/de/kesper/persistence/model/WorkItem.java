/*
 *  03.09.2014 (C) KV RLP
 */

package de.kesper.persistence.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author kesper
 */
@Entity
public class WorkItem implements Serializable {
    private Long id;
    
    private String name;
    private float units = 0.F;
    private float pricePerUnit = 0.F;
    private float tax = 0.F;
    private float discountedPrice = 0.F;
    private OrderSet orderSet;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnits() {
        return units;
    }

    public void setUnits(float units) {
        this.units = units;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public float getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(float discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public OrderSet getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(OrderSet orderSet) {
        this.orderSet = orderSet;
    }
}
