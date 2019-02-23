package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class B_KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String> print = w -> System.out.println("Sir " + w);

        List<String> list = Arrays
                .stream(reader.readLine().split(" "))
                .collect(Collectors.toList());

        list.stream().forEach(print);
    }
}
