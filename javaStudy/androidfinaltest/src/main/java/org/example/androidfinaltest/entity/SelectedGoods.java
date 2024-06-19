package org.example.androidfinaltest.entity;

public class SelectedGoods {
//    private Integer Image;
    private int id;
    private String image;
    private String name;
    private String price;
    private int count;
    private int inventory;
    private String username;
    public SelectedGoods(){}

    public SelectedGoods(int id, String image, String name, String price, int count) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.count = count;
    }
    //    public SelectedGoods(Integer image, String name, String price, int count) {
//        Image = image;
//        this.name = name;
//        this.price = price;
//        this.count = count;
//    }


    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
//    public Integer getImage() {
//        return Image;
//    }
//
//    public void setImage(Integer image) {
//        Image = image;
//    }

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
