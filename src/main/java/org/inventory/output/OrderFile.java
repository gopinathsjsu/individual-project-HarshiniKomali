package org.inventory.output;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class OrderFile implements OutputFile {
    private ArrayList<String> content;

    @Override
    public void writeToFile(ArrayList<String> content) {
        this.content = content;
    }

    @Override
    public void save(Path path) throws IOException {
        FileWriter orderFile = new FileWriter(path.getParent().toString()+"/order_file_"+new SimpleDateFormat("yyyyMMddHHmm").format(new Date())+".csv");
        for(String line:content) {
            orderFile.write(line+"\n");
        }
        orderFile.close();
    }

}
