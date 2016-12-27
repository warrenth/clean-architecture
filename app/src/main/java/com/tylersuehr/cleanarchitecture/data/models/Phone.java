package com.tylersuehr.cleanarchitecture.data.models;

import java.util.UUID;
/**
 * Copyright 2016 Tyler Suehr
 * Created by tyler on 12/25/2016.
 */
public class Phone extends Entity {
    private String make;
    private String model;
    private double price;
    private String carrier;


    public Phone() {
        setId(UUID.randomUUID()); // Ensure unique id
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
}