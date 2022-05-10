package org.inventory.controller;

import org.inventory.model.Inventory;
import org.inventory.output.FileHelper;

import java.io.IOException;
import java.util.HashSet;

public class ReadCardData {
    private final Inventory inventory = Inventory.getInstance();

    public ReadCardData(String cardFilePath) throws IOException {
        FileHelper fileHelper = new FileHelper(cardFilePath);
        HashSet<String> cardsData = inventory.getCardsDatabase();

        try {
            fileHelper.fileReader(true);
        } catch(Exception e) {
            System.out.println("Cards file does not exist. Please enter a valid file path");
            System.exit(0);
        }
        cardsData.addAll(fileHelper.getContent());
    }
}
