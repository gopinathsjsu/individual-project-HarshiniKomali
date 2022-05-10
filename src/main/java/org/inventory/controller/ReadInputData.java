package org.inventory.controller;
import org.inventory.model.Inventory;
import org.inventory.model.Items;
import org.inventory.model.OrderItems;
import org.inventory.model.Orders;
import org.inventory.output.FileHelper;
import org.inventory.validators.ItemCategoryCapValidator;
import org.inventory.validators.ItemPresenceValidator;
import org.inventory.validators.ItemStockValidator;
import org.inventory.validators.ValidationHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.io.IOException;
public class ReadInputData {
    private final Inventory inventory = Inventory.getInstance();
    private final Orders currOrder = new Orders();
    private FileHelper fileHelper;
    private final ArrayList<String> output = new ArrayList<>();
    private final ArrayList<OrderItems> items = new ArrayList<>();
    private final HashSet<String> cards = inventory.getCardsDatabase();
    private double total = 0;

    public ReadInputData() {}

    public ReadInputData(String filename) {
        fileHelper = new FileHelper(filename);
    }

    public void addToOutput(String content) {
        output.add(content);
    }

    public boolean processOrder() {
        try {
            fileHelper.fileReader(true);
        } catch(Exception e) {
            return false;
        }
        getItems(fileHelper.getContent());
        return true;
    }

    public boolean checkOrder() {
        checkStock();
        if(output.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void calculateTotal() {
        for(OrderItems item: items) {
            total += item.getQuantity()*inventory.getStockInventoryDatabase().get(item.getName()).getPrice();
        }
        currOrder.setTotalPrice(total);
    }

    public double getTotal() {
        return currOrder.getTotalPrice();
    }

    public void checkoutOrder() {
        for(OrderItems orderItem:items) {
            Items item = inventory.getStockInventoryDatabase().get(orderItem.getName());
            item.setQuantity(item.getQuantity()-orderItem.getQuantity());
        }
        for(String card: cards) {
            if(!inventory.getCardsDatabase().contains(card)) {
                inventory.getCardsDatabase().add(card);
            }
        }
        generateOutputFile();
    }

    public void getItems(ArrayList<String> content) {
        for (String line: content) {
            String[] item = line.split(",");
            if(inventory.getStockInventoryDatabase().containsKey(item[0])) {
                items.add(new OrderItems(item[0],Integer.parseInt(item[1]),item[2].replaceAll("\\s+","")));
            } else {
                output.add("Requested item " + item[0] + "does not exist");
            }
        }
        if(!output.isEmpty()) {
            items.clear();
        }
    }

    public void checkStock() {
        inventory.getOrderDatabase().add(currOrder);
        ValidationHandler itemPresence = new ItemPresenceValidator();
        ValidationHandler itemStock = new ItemStockValidator();
        ValidationHandler itemCategory = new ItemCategoryCapValidator();
        String itemPresenceValidation = itemPresence.validate(items);
        String itemQuantityValidation = itemStock.validate(items);
        String itemCategoryLimitValidation = itemCategory.validate(items);
        if(!itemPresenceValidation.isEmpty()){
            output.add("Please fix the following error.");
            output.add(itemCategoryLimitValidation);
        }
        if(!itemQuantityValidation.isEmpty()){
            output.add("Please fix the following error.");
            output.add(itemQuantityValidation);
        }
        if(!itemCategoryLimitValidation.isEmpty()){
            output.add("Please fix the following error.");
            output.add(itemCategoryLimitValidation);
        }
        if(output.size()==0) {
            for (OrderItems orderItem : items) {
                if (!cards.contains(orderItem.getCardDetails()))
                    cards.add(orderItem.getCardDetails());
            }
        }

    }
    public void generateOutputFile(){
        //System.out.println("Zing Zing Amazing");
        if(output.size()==0){
            output.add("Amount Paid");
            output.add(Double.toString((currOrder.getTotalPrice())));
            try{
                fileHelper.writeOutput(output,false);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            try{
                fileHelper.writeOutput(output,true);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }



}

