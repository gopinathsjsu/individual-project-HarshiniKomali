package org.inventory.validators;

import org.inventory.model.Inventory;
import org.inventory.model.OrderItems;

import java.util.ArrayList;

public class ItemPresenceValidator implements ValidationHandler{
    @Override
    public String validate(ArrayList<OrderItems> orderItems) {
        Inventory inventory = Inventory.getInstance();
        for(OrderItems item: orderItems) {
            if(!inventory.getStockInventoryDatabase().containsKey(item.getName())) {
                return String.format("Requested item %s is not present in the inventory database",item.getName());
            }
        }
        return "";
    }
}
