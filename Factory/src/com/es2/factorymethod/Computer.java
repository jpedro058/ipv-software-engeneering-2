package com.es2.factorymethod;
public class Computer extends java.lang.Object implements Product {
    private String brand;


    protected Computer() {
        //Constructor
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String Brand ) {
        this.brand = Brand;
    }


}
