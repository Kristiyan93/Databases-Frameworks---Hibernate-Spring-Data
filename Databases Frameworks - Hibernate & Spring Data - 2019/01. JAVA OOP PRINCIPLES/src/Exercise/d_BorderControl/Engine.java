package Exercise.d_BorderControl;

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

        List<Border> borders = new ArrayList<>();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            switch (tokens.length) {
                case 3:
                    Border citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                    borders.add(citizen);
                    break;
                case 2:
                    Border robot = new Robot(tokens[0], tokens[1]);
                    borders.add(robot);
                    break;
                    default:
                        break;
            }

            input = this.scanner.nextLine();
        }

        boolean isContains = true;

        String in = this.scanner.nextLine();

        List<String> result = new ArrayList<>();

        for (Border b : borders) {
            for (int i = 0; i < in.length(); i++) {
                char c = b.getId().charAt(b.getId().length() + i - in.length());
                if (in.charAt(i) != c) {
                    isContains = false;
                }
            }
            if (isContains) {
                result.add(b.getId());
            }

            isContains = true;
        }

        for (String s : result) {
            System.out.println(s);
        }
    }
}
