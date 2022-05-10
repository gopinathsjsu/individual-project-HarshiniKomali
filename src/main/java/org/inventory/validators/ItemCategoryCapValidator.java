package org.inventory.validators;

import org.inventory.model.Inventory;
import org.inventory.model.OrderItems;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemCategoryCapValidator implements ValidationHandler{
    private final int essentialItemsLimit = 40;
    private final int luxuryItemsLimit = 30;
    private final int miscItemsLimit = 60;

    @Override
    public String validate(ArrayList<OrderItems> orderItems) {
        HashMap<String,Integer> items = new HashMap<>();
        Inventory inventory = Inventory.getInstance();

        for(OrderItems item:orderItems) {
            items.put(inventory.getStockInventoryDatabase().get(item.getName()).getCategory(),items.getOrDefault(inventory.getStockInventoryDatabase().get(item.getName()).getCategory(),0)+item.getQuantity());
        }
        if(items.getOrDefault("Luxury",0) > luxuryItemsLimit) {
            return String.format("Requested quantity %d for %s category exceeds the limit. There are %d items only.",items.getOrDefault("Luxury",0),"Luxury",luxuryItemsLimit);
        } else if(items.getOrDefault("Essential",0) > essentialItemsLimit) {
            return String.format("Requested quantity %d for %s category exceeds the limit. There are %d items only.",items.getOrDefault("Essential",0),"Essential",essentialItemsLimit);
        } else  if(items.getOrDefault("Misc",0) > miscItemsLimit) {
            return String.format("Requested quantity %d for %s category exceeds the limit. There are %d items only.",items.getOrDefault("Misc",0),"Misc",miscItemsLimit);
        }

        return "";
    }
}
