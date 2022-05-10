# Individual Project HarshiniKomali

## Problem Statement
Design and implement a Java application for the following requirements. You may choose up to 3 design patterns. Include a class diagram for your design. All submissions should be committed to the assigned Github repo. Please include a README file with very clear instructions on how to build and run your application.

## Steps to run the project
1. Install Java 8 in the machine that will run the program
2. Download the code from the repository.
3. Open cmd/terminal and go to "target" folder. Here you can see a jar file "cmpe202_individual-1.0-SNAPSHOT.jar"
4. Run the command "java -jar cmpe202_individual-1.0-SNAPSHOT.jar <Path to inventory.csv file> <Path to cards.csv file> <Path to order.csv file>".
5. Output files will be generaterd in the same folder as the input files.

## Design Patterns used
1. Singleton
2. Factory
3. Chain of Responsibility
 
1. Singleton Pattern: 
 * This pattern is a creational pattern which ensures that a class has only one instance created by providing global access to the instance.
 * This pattern is used for connecting to the inventory database.
 * The "Inventory" class is the database class in this application which is present in the models folder. We use getInstance() method to check if an instance of the     Inventory class is already created or not. If it exists, we use the existing instance, otherwise an instance is created. This ensures that only single instance of the Inventory class is created and used.
 
  ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/class_diagrams/singleton.png)
 
 
 
2. Factory Pattern:
 * It is a creational design pattern that provides an interface for creating objects in the superclass and the subclasses can alter the type of objects they create.
 * This pattern is used for the output file generation.
 * The "OutputFile" which is present in the output folder is an interface. The "OrderFile" implements the OutputFile when the order is successful to create the output.csv file and the "ErrorFile" implements to create the error file in case of any errors.
 
 ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/class_diagrams/factory_pattern.png)
 
 
 
3. Chain of Responbility Pattern:
 * It is a behavioral design pattern that lets you pass requests along a chain of handlers. Upon receiving a request, each handler decides whether to process the request or to pass it to the next handler in the chain.
 * This pattern is to determine if the order can be processed correctly or not. The following files are used in this pattern:
   * Interface ValidationHandler
   * Class ItemPresenceValidator
   * Class ItemStockValidator
   * Class ItemCategoryCapValidator
 The ValidationHandler is the interface. The ItemPresenceValidator checks is the requested item is present in the inventory database or not. The ItemStockvalidator checks if the requested stock for the item is present or not. The ItemCategoryCapValidator checks the if the user requested items of a particular category which exceeds its maximum limit.
 
 ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/class_diagrams/cor.png)
 
 
 
 ## Maximum Limits for different categories
 1. Essential items: 40
 2. Luxury items: 30
 3. Miscellaneous items: 60
 
 ## Code Execution
  * Inventory file path not given
 
    ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/screenshots/screenshot_1.png)
 
  * Card data file path not given
    
    ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/screenshots/screenshot_2.png)
 
  * Order data file path not given
    
    ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/screenshots/screenshot_3.png)
 
  * For the deafult input (the input given in the canvas example)
 
    ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/screenshots/screenshot_4.png)
 
  * For a valid input with different numbers
 
    ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/screenshots/screenshot_5.png)
 
  * When the requested item is missing
   
    ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/screenshots/screenshot_6.png)
 
  * When the category limit exceeded
 
    ![alt_text](https://github.com/gopinathsjsu/individual-project-HarshiniKomali/blob/main/screenshots/screenshot_7.png)
 
 
 
   
 

