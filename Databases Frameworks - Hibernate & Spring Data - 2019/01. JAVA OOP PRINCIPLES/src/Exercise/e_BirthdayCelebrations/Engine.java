package Exercise.e_BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final Scanner scanner;

    public Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        String input = this.scanner.nextLine();

        List<Birthday> borders = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "Citizen":
                    Celebration citizen = new Citizen(tokens[1], Integer.parseInt(tokens[2]),tokens[3], tokens[4]);
                    borders.add(citizen);
                    break;
                case "Pet":
                    Celebration pet = new Pet(tokens[1], tokens[2]);
                    borders.add(pet);
                    break;
                    default:
                        break;
            }

            input = this.scanner.nextLine();
        }

        List<String> result = new ArrayList<>();

        String in = this.scanner.nextLine();

        for (Birthday border : borders) {
            if (border.checkBirthay(in)) {
                result.add(border.getBirthday());
            }
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
