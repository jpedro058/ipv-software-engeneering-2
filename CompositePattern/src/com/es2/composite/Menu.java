package com.es2.composite;

public abstract class Menu extends Object{

    private String label;

    //Returns the label
    public java.lang.String getLabel(){
        return label;
    }

    //Sets the label
    public void setLabel(java.lang.String label){
        this.label = label;
    }

    //Print the combination of label and URL
    public abstract void showOptions();
     }