package org.inventory.model;

public class Items {
    private final String name;
    private final String category;
    private final double price;
    private int quantity;

    public Items(String category, String name,int quantity,double price){
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }
    public String getItemName() {
        return name;
    }
    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
