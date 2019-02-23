package Exercise.f_GenericCountMethodDoubles;

import Exercise.a_GenericBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            Double input = Double.parseDouble(scanner.nextLine());
            list.add(input);
        }

        Double element = Double.parseDouble(scanner.nextLine());

        System.out.println(Box.getCount(list, element));
    }
}
