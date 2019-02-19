package Exercise.i_Animals;

import Exercise.i_Animals.animals.*;
import Exercise.i_Animals.animals.Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Running implements Runnable {
    private Scanner scanner;
    private List<Animals> animals;

    public Running(Scanner scanner) {
        this.scanner = scanner;
        this.animals = new ArrayList<>();
    }

    @Override
    public void run() {
        String input = this.scanner.nextLine();

        while (!input.equals("Beast!")) {
            String[] tokens = this.scanner.nextLine().split("\\s+");
            try {
                switch (input) {
                    case "Cat":
                        Animals cat = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        this.animals.add(cat);
                        break;
                    case "Dog":
                        Animals dog = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        this.animals.add(dog);
                        break;
                    case "Frog":
                        Animals frog = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        this.animals.add(frog);
                        break;
                    case "Kittens":
                        Animals kitten = new Kittens(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        this.animals.add(kitten);
                        break;
                    case "Tomcat":
                        Animals tomcat = new Tomcat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        this.animals.add(tomcat);
                        break;
                        default:
                            throw new IllegalArgumentException("Invalid input!");
                }
            }catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            input = this.scanner.nextLine();
        }

        for (Animals a : animals) {
            System.out.println(a.toString());
            System.out.println(a.produceSound());
        }
    }
}
