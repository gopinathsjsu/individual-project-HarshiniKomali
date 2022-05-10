package org.inventory.controller;

import org.inventory.model.Inventory;
import org.inventory.model.Items;
import org.inventory.output.FileHelper;

import java.io.IOException;

public class ReadInventoryData {
    private final Inventory inventory = Inventory.getInstance();

    public ReadInventoryData(String inventoryFilePath) throws IOException {
        FileHelper fileHelper = new FileHelper(inventoryFilePath);
        try {
            fileHelper.fileReader(true);
        } catch(Exception e) {
            System.out.println("Inventory file does not exist. Please enter a valid file path");
            System.exit(0);
        }
        for(String line:fileHelper.getContent()) {
            String[] item = line.split(",");
            inventory.getStockInventoryDatabase().put(item[1],new Items(item[0],item[1],Integer.parseInt(item[2]),Double.parseDouble(item[3])));
        }


    }
}
