package org.inventory.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Inventory {
    private static Inventory inventoryInstance;
    private final HashMap<String, Items> stockInventoryDatabase = new HashMap<>();
    private final HashSet<String> cardsDatabase = new HashSet<>();
    private final ArrayList<Orders> orderDatabase = new ArrayList<>();

    private Inventory() {}

    public static Inventory getInstance() {
        if(inventoryInstance == null) {
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }

    public HashMap<String,Items> getStockInventoryDatabase(){
        return stockInventoryDatabase;
    }
    public HashSet<String> getCardsDatabase() {
        return cardsDatabase;
    }
    public ArrayList<Orders> getOrderDatabase() {
        return orderDatabase;
    }
}
