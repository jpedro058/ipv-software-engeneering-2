package com.es2.singleton;
public class Registry extends Object {
    private static Registry instance;
    private String path;
    private String connectionString;

    private Registry() {
        //Constructor
    }

    public static Registry getInstance() {
        if (instance == null) {
            instance = new Registry();
        }
        return instance;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
}
