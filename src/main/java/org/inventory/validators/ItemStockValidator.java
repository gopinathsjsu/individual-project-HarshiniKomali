package org.inventory.validators;

import org.inventory.model.Inventory;
import org.inventory.model.OrderItems;

import java.util.ArrayList;

public class ItemStockValidator implements ValidationHandler{
    @Override
    public String validate(ArrayList<OrderItems> orderItems) {
        Inventory inventory = Inventory.getInstance();
        for(OrderItems item: orderItems) {
            if(inventory.getStockInventoryDatabase().get(item.getName()).getQuantity()<item.getQuantity()) {
                return String.format("Requested quantity %d for %s is not present. There are only %d items",item.getQuantity(),item.getName(),inventory.getStockInventoryDatabase().get(item.getName()).getQuantity());
            }
        }
        return "";
    }
}
