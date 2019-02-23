package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class D_AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays
                .stream(reader.readLine().split(" "))
                .map(Integer::new)
                .collect(Collectors.toList());


        boolean isPrint = false;


        String input = reader.readLine();

        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    list = list.stream().map(x -> x + 1).collect(Collectors.toList());
                    break;
                case "multiply":
                    list = list.stream().map(x -> x * 2).collect(Collectors.toList());
                    break;
                case "subtract":
                    list = list.stream().map(x -> x - 1).collect(Collectors.toList());
                    break;
                case "print":
                    isPrint = true;
                    list.stream().forEach(x -> System.out.printf("%d ", x));
                    System.out.println();
                    break;
            }

            input = reader.readLine();
        }

        if (!isPrint) {
            list.stream().forEach(x -> System.out.printf("%d ", x));
        }
    }
}
