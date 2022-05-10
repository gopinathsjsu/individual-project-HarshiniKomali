package org.inventory;
import org.inventory.controller.ReadCardData;
import org.inventory.controller.ReadInputData;
import org.inventory.controller.ReadInventoryData;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Billing
{
    public static void main( String[] args ) throws IOException {
        if(args.length == 0) {
            System.out.println("Please input Inventory Data as first argument");
            System.exit(0);
        }
        if(args.length == 1) {
            System.out.println("Please input Cards Data as second argument");
            System.exit(0);
        }
        if(args.length == 2) {
            System.out.println("Please input Order Data as third argument");
            System.exit(0);
        }
        ReadInventoryData readInventoryData = new ReadInventoryData(args[0]);
        ReadCardData readCardData = new ReadCardData(args[1]);
        processInputOrder(args[2]);

    }
    private static void processInputOrder(String inputPath){
        ReadInputData readInputData = new ReadInputData(inputPath);
        if(readInputData.processOrder()){
            if(readInputData.checkOrder()){
                readInputData.calculateTotal();
                if(readInputData.getTotal()>0){
                    readInputData.checkoutOrder();
                    System.out.println("The total amount is $" + readInputData.getTotal());
                }
            }else {
                System.out.println("Error file generated.");
                readInputData.generateOutputFile();
            }
        }else {
            System.out.println("Input order file not found");
        }
    }
}
