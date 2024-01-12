/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenovo
 */
public class CD implements Comparable<CD>{
    
    private String id;
    private String collectionName;
    private String type;
    private String title;
    private double unitPrice;
    private int publishYear;	
    

    public CD() {
    }

    public CD(String id, String collectionName, String type, String title, double unitPrice, int publishYear) {
        this.id = id;
        this.collectionName = collectionName;
        this.type = type;
        this.title = title;
        this.unitPrice = unitPrice;
        this.publishYear = publishYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }


    @Override
    public String toString() {
        return id + " _ " + collectionName + " _ " + type + " _ " + title + " _ " + unitPrice + " _ " + publishYear;
    }
    
    @Override
    public int compareTo(CD c) {
        return this.getId().compareTo(c.getId());
    }
    
}
