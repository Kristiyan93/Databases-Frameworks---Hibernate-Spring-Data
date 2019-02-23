package Exercise.e_GenericCountMethodStrings;

import Exercise.a_GenericBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String input = scanner.nextLine();
            list.add(input);
        }

        String element = scanner.nextLine();

        System.out.println(Box.getCount(list, element));
    }
}
