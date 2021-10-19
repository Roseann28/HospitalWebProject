package com.hospital.services.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Service implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private BigDecimal price;

    public Service() {
    }

    public Service(String name) {
        this.name = name;
    }

    public Service(int id, String name, int quantity, BigDecimal price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  id +","+ name +"," + quantity +"," + price ;
    }
}
