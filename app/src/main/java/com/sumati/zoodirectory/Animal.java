package com.sumati.zoodirectory;

import java.io.Serializable;

/**
 * Created by sumati on 1/30/16.
 */
public class Animal implements Serializable{

    private String name;
    private String filename;
    private String description;

    public Animal(String name, String filename) {
        this.name = name;
        this.filename = filename;
    }

    public Animal(String name, String filename, String description) {
        this.name = name;
        this.filename = filename;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
