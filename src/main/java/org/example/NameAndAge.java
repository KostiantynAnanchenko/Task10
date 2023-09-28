package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class NameAndAge {


    public static void usersList(String filePath) {

        List<User> users = new ArrayList<>();
        Gson gson = new Gson();

        Pattern namePattern = Pattern.compile("\\b(?!(Name|Age)\\b)[a-zA-Z]+\\b", Pattern.CASE_INSENSITIVE);
        Pattern agePattern = Pattern.compile("\\b\\d+\\b");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                Matcher nameMatcher = namePattern.matcher(line);
                Matcher ageMatcher = agePattern.matcher(line);

                if (nameMatcher.find() && ageMatcher.find()) {
                    users.add(new User(nameMatcher.group(), Integer.valueOf(ageMatcher.group())));

                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        String json = gson.toJson(users);
        System.out.println(json);

        try (FileWriter writer = new FileWriter("user.json")) {

            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;

        }
    }
}
