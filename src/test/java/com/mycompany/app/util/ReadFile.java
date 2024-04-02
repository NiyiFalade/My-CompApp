package com.mycompany.app.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {

    public ArrayList<String> processFile(String filePath) {

        ArrayList<String> caReglist = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

                // Create a Pattern object
                String[] regexPatterns = {"[A-Z]{2}[0-9]{2}\\s[A-Z]{3}", "[A-Z]{2}[0-9]{2}[A-Z]{3}"};

                for (String regex : regexPatterns) {
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(line);

                    while (matcher.find()) {
                        caReglist.add(matcher.group());
                        //System.out.println("Extracted text: " + extractedText);
                    }
                }
            }
        } catch (IOException e) {
            // Handle any IO exceptions
            e.printStackTrace();
        }
        return caReglist;
    }


}


