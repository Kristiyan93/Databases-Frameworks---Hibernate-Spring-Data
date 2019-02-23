package Exercise.d_GenericSwapMethodIntegers;

import Exercise.a_GenericBox.Box;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            int input = Integer.parseInt(scanner.nextLine());

            list.add(input);
        }

        int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstIndex = tokens[0];
        int secomndIndex = tokens[1];

        int current = list.get(firstIndex);

        list.set(firstIndex, list.get(secomndIndex));
        list.set(secomndIndex, current);

        list.stream().forEach(s -> System.out.println(new Box<>(s)));
    }
}
