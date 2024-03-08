package com.es2.composite;

public class Link extends Menu {

    private String URL;

    public Link() {
    }

    // Gets the link's URL
    public String getURL() {
        return URL;
    }

    // Sets the link's URL
    public void setURL(String URL) {
        this.URL = URL;
    }

    // Prints the label and URL of the link
    @Override
    public void showOptions() {
        System.out.println(getLabel());
        System.out.println(getURL());
    }
}
