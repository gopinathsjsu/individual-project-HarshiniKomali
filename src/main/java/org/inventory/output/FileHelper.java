package org.inventory.output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHelper {
    Path filePath;
    OutputFile outputFile;

    private ArrayList<String> content = new ArrayList<>();

    public FileHelper(String filePath) {
        this.filePath = Paths.get(filePath);
    }

    public void fileReader(boolean firstLine) throws Exception {
        if(Files.exists(filePath)) {
            BufferedReader reader = new BufferedReader((new FileReader(filePath.toFile())));
            String line = "";

            while((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                content.add(line);
            }
        } else {
            throw new Exception();
            }
        }

    public ArrayList<String> getContent() {
        return content;
    }
    public void writeOutput(ArrayList<String> message, boolean isError) throws IOException {
        if(isError) {
            outputFile = new ErrorFile();
        } else {
            outputFile = new OrderFile();
        }
        outputFile.writeToFile(message);
        outputFile.save(filePath);

    }


}
