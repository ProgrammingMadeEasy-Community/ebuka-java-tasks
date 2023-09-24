package org.javatasks.daysoftheweek;


import java.util.*;

public class DaysOfTheWeekProgram {
    enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number (1-7):");
        int userInput = scanner.nextInt();

        if (userInput >= 1 && userInput <= 7) {
            if (userInput == 1) {
                DaysOfTheWeek(userInput);
            } else {
                System.out.println("Enter 2 or 3 numbers (1-7):");
                int input1 = scanner.nextInt();
                if (userInput == 2) {
                    DaysOfTheWeek(input1);
                } else if (userInput == 3) {
                    int input2 = scanner.nextInt();
                    DaysOfTheWeek(input1, input2);
                } else {
                    System.out.println("Invalid input.");
                }
            }
        } else {
            System.out.println("Invalid input.");
        }
    }

    // Task 1: Method to display the corresponding day of the week
    public static void DaysOfTheWeek(int dayNumber) {
        try {
            DayOfWeek[] days = DayOfWeek.values();
            System.out.println("Corresponding day of the week: " + days[dayNumber - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
        }
    }

    // Task 3: Method to store and count user inputs
    public static void DaysOfTheWeek(int... dayNumbers) {
        try {
            Map <DayOfWeek, Integer> dayCountMap = new HashMap<>();
            for (int dayNumber : dayNumbers) {
                DayOfWeek day = DayOfWeek.values()[dayNumber - 1];
                dayCountMap.put(day, dayCountMap.getOrDefault(day, 0) + 1);
            }

            for (Map.Entry<DayOfWeek, Integer> entry : dayCountMap.entrySet()) {
                System.out.println("Dictionary: key - " + entry.getKey() + ", Value - " + entry.getValue());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input. Please enter numbers between 1 and 7.");
        }
    }
}
