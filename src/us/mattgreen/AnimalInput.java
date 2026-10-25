
package us.mattgreen;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalInput {

    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Talkable> zoo;

    public AnimalInput(ArrayList<Talkable> zoo) {
        this.zoo = zoo;
    }

    public void addAnimal() {
        while (true) {
            System.out.println("What would you like to create?");
            System.out.println("1. Dog");
            System.out.println("2. Cat");
            System.out.println("3. Teacher");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    String dogName = getValidName("Enter the dog's name: ");
                    boolean friendly = getValidBoolean("Is the dog friendly? (true/false): ");

                    zoo.add(new Dog(friendly, dogName));
                    return;

                case "2":
                    String catName = getValidName("Enter the cat's name: ");
                    int lives;

                    do {
                        lives = getValidNumber("How many lives does the cat have? ");

                        if (lives > 9) {
                            System.out.println("Please enter a number between 1 and 9.");
                        }
                    } while (lives > 9);

                    zoo.add(new Cat(lives, catName));
                    return;

                case "3":
                    String teacherName = getValidName("Enter the teacher's name: ");
                    int age = getValidNumber("Enter the teacher's age: ");

                    zoo.add(new Teacher(age, teacherName));
                    return;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }
        }
    }

    private String getValidName(String message) {
        while (true) {
            System.out.print(message);
            String name = scanner.nextLine().trim();

            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Name cannot be empty.");
        }
    }

    private int getValidNumber(String message) {
        while (true) {
            System.out.print(message);

            try {
                int number = Integer.parseInt(scanner.nextLine().trim());

                if (number < 1) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }

                return number;

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private boolean getValidBoolean(String message) {
        while (true) {
            System.out.print(message);
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("true")) {
                return true;
            } else if (answer.equalsIgnoreCase("false")) {
                return false;
            }

            System.out.println("Invalid input. Please enter true or false.");
        }
    }
}
