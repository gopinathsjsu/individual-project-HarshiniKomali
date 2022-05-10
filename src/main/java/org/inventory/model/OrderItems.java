package org.inventory.model;

public class OrderItems {
    private String name;
    private int quantity;
    private String cardDetails;

    public OrderItems(String name, int quantity, String cardDetails) {
        this.name = name;
        this.quantity = quantity;
        this.cardDetails = cardDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCardDetails() {
        return cardDetails;
    }
    public void setCardDetails(String cardDetails) {
        this.cardDetails=cardDetails;
    }
}
