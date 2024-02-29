package com.es2.factorymethod;

public abstract class FactoryProduct extends Object {

    private static FactoryProduct instance;
    private String product;

    private FactoryProduct() {
        //Constructor
    }


    //Parameters:
    //type - Selector of the object type. Options are or Software.
    //Returns:
    //The object created by the factory.
    public static Product makeProduct (String type) throws UndefinedProductException {
        if (type.equals("Computer")) {
            return new Computer();
        } else if (type.equals("Software")) {
            return new Software();
        } else {
            throw new UndefinedProductException("Product not defined");
        }
    }

}
