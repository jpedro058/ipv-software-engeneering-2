package com.es2.factorymethod;

public class Software extends java.lang.Object implements Product{
    private String brand;

    protected Software() {
        //Constructor
    }
    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String Brand ) {
        this.brand = Brand;
    }
}
