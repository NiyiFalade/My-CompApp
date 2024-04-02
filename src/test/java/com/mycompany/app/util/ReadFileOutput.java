package com.mycompany.app.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileOutput {
    public ArrayList<String> processFile(String filePath) {

        ArrayList<String> caReglist = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (line.contentEquals("MAKE_MODEL,VARIANT_REG,YEAR_BODY")) {
                    //do nothing
                } else {
                    caReglist.add(line);
                }
            }
        } catch (IOException e) {
            // Handle any IO exceptions
            e.printStackTrace();
        }
        return caReglist;
    }
}
