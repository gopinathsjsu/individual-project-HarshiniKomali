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
   
 

