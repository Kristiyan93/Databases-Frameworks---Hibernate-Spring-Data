package Exercise.b_GenericBoxOfInteger;

import Exercise.a_GenericBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box> boxes = new ArrayList<>();

        while (n-- > 0) {
            int num = Integer.parseInt(scanner.nextLine());

            Box box = new Box(num);

            boxes.add(box);
        }

        boxes.stream()
                .forEach(s -> System.out.println(s.toString()));
    }
}
