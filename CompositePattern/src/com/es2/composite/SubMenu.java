package com.es2.composite;

import java.util.ArrayList;
import java.util.List;

public class SubMenu extends Menu{

    private List<Menu> children;

    public SubMenu() {
        children = new ArrayList<>();
    }

    // Adds a child element (link | submenu) to the menu
    public void addChild(Menu child) {
        children.add(child);
    }

    // Removes a child element (link | submenu)
    public void removeChild(Menu child) {
        children.remove(child);
    }

    // Shows all the options (label/URL) of the current submenu
    public void showOptions() {
        System.out.println(getLabel());
        for (Menu child : children) {
            child.showOptions(); // Assuming you want to print labels
        }
    }
}

