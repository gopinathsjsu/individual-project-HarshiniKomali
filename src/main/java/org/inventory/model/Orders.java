package org.inventory.model;

import java.util.HashSet;

public class Orders {
    private double totalPrice;
    private HashSet<Items> items = new HashSet<>();
    public Orders() {}

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public HashSet<Items> getItems() {
        return items;
    }

    public void setItems(HashSet<Items> items) {
        this.items = items;
    }
}
