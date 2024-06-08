package org.example.task05.entity;

public class Cake {
    private int id;
    private String name;
    private int price;
    private int state;

    public Cake(){}
    public Cake(int id, String name, int price, int state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.state = state;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
