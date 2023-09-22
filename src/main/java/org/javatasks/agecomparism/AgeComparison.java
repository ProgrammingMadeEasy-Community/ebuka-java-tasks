package org.javatasks.agecomparism;

import java.util.Scanner;





public class AgeComparison {
    public static void main(String[] args) {
        Person person1 = FillPerson();
        Person person2 = FillPerson();

        whoIsOlder(person1, person2);
    }

    public static Person FillPerson() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the person's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the birth year (e.g., 1990): ");
        int year = scanner.nextInt();

        System.out.print("Enter the birth month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter the birth day (1-31): ");
        int day = scanner.nextInt();

        Date birthday = new Date(year, month, day);

        return new Person(name, birthday);
    }

    public static void writePerson(Person person) {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        System.out.println("Name: " + person.name);
        System.out.println("Birthday: " + monthNames[person.birthday.month - 1] + " " + person.birthday.day + ", " + person.birthday.year);
    }

    public static void whoIsOlder(Person person1, Person person2) {
        int yearDifference = person1.birthday.year - person2.birthday.year;

        if (yearDifference < 0) {
            System.out.println(person1.name + " is younger than " + person2.name + " by " + (-yearDifference) + " years.");
        } else if (yearDifference > 0) {
            System.out.println(person1.name + " is older than " + person2.name + " by " + yearDifference + " years.");
        } else {
            int monthDifference = person1.birthday.month - person2.birthday.month;

            if (monthDifference < 0) {
                System.out.println(person1.name + " is younger than " + person2.name + " by a few months.");
            } else if (monthDifference > 0) {
                System.out.println(person1.name + " is older than " + person2.name + " by a few months.");
            } else {
                int dayDifference = person1.birthday.day - person2.birthday.day;

                if (dayDifference < 0) {
                    System.out.println(person1.name + " is younger than " + person2.name + " by a few days.");
                } else if (dayDifference > 0) {
                    System.out.println(person1.name + " is older than " + person2.name + " by a few days.");
                } else {
                    System.out.println(person1.name + " and " + person2.name + " have the same birthday.");
                }
            }
        }

        System.out.println("org.javatasks.agecomparism.Person 1:");
        writePerson(person1);

        System.out.println("org.javatasks.agecomparism.Person 2:");
        writePerson(person2);
    }
}
