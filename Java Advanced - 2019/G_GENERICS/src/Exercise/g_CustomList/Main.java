package Exercise.g_CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Custom<String> box = new Custom<>();

        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    box.addElement(tokens[1]);
                    break;
                case "Max":
                    System.out.println(box.getMax());
                    break;
                case "Min":
                    System.out.println(box.getMin());
                    break;
                case "Greater":
                    System.out.println(box.countGreaterThan(tokens[1]));
                    break;
                case "Swap":
                    box.swap(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                    break;
                case "Contains":
                    System.out.println(box.contains(tokens[1]));
                    break;
                case "Remove":
                    box.remove(Integer.parseInt(tokens[1]));
                    break;
                case "Print":
                    System.out.println(box.toString());
                    break;
                case "Sort":
                    box.sort();
                    break;

            }

            input = scanner.nextLine();
        }

        System.out.println();
    }
}
