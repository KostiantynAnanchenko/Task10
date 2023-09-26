package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {


    public static void validatePhoneNumbers(String filePath){
        Pattern phonePattern = Pattern.compile("(\\(\\d{3}\\) \\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine())!=null){
                Matcher matcher = phonePattern.matcher(line);
                if(matcher.find()){

                System.out.println(matcher.group());
                }
            }


        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


}
