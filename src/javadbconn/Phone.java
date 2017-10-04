/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadbconn;

/**
 *
 * @author ravi
 * This is our model class
 */
public class Phone {
    private int id;
    private String name;
    private String price;
    private String description;
    private String dateCreated;
    

    public Phone(int id, String name, String price, String description, String dateCreated) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.dateCreated = dateCreated;
        
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    
}
