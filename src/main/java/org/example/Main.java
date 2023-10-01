package org.example;


public class Main {

    public static void main(String[] args) {

        System.out.println("--- Task 10.1 Test ---");

        PhoneNumbers.validatePhoneNumbers("src/main/resources/file.txt");


        System.out.println("--- Task 10.2 Test ---");

        NameAndAge.usersList("src/main/resources/Names and ages/file.txt");



        System.out.println("--- Task 10.3 Test ---");

       WordFrequency.wordCounter( "src/main/resources/words.txt");

    }
}