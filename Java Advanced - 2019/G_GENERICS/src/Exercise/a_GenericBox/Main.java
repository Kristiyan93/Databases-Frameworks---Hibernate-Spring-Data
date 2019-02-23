package Exercise.a_GenericBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Box> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String input = scanner.nextLine();
            Box box = new Box(input);
            list.add(box);
        }

        list.stream()
                .forEach(s -> System.out.println(s.toString()));
    }
}
