package com.kenzie.app;

// import necessary libraries
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Scanner;

public class Main {
    /* Java Fundamentals Capstone project:
       - Define as many variables, properties, and methods as you decide are necessary to
       solve the program requirements.
       - You are not limited to only the class files included here
       - You must write the HTTP GET call inside the CustomHttpClient.sendGET(String URL) method
         definition provided
       - Your program execution must run from the main() method in Main.java
       - The rest is up to you. Good luck and happy coding!

     */
    public static int randomNum(){

        return (int)Math.floor((Math.random() * 100) + 1);
    }


    public static void main(String[] args)  {
        try {
        String URL = "https://jservice.kenzie.academy/api/clues";
        String responseBody = CustomHttpClient.sendGET(URL);
        String answer = "";
        String userAnswer = "";
        String playGame = "";
        Scanner sc = new Scanner(System.in);
        int points = 0;
        int random = randomNum();
        int counter = 0;

        //JSON Mapping
            //1. Instantiate Object Mapper
            //2. create DTO
            //3. readValue
            ObjectMapper objectMapper = new ObjectMapper();
            jServiceDTO jServiceObj;
            jServiceObj = objectMapper.readValue(responseBody, jServiceDTO.class);

            //asking the user a question
            System.out.println("Would You like to play a game? Y/N");
            playGame = sc.nextLine();
            while(playGame.equalsIgnoreCase("y") || counter < 10) {
                System.out.println("The question is: " + jServiceObj.getClues().get(random).getQuestion());
                System.out.println("The Category: " + jServiceObj.getClues().get(random).getCategories().getTitle());
                answer = jServiceObj.getClues().get(random).getAnswer();
                System.out.println("What is the answer?");
                userAnswer = sc.nextLine();
                if (userAnswer.equalsIgnoreCase(answer)) {
                    System.out.println("That is the correct answer, Good Job!");
                    points++;
                } else {
                    System.out.println("incorrect answer...");
                    System.out.println("The correct answer was: " + answer);
                }
                counter++;
                random = randomNum();
            }
            System.out.println("Thanks for playing!");
            System.out.println("Your total points are " + points);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

