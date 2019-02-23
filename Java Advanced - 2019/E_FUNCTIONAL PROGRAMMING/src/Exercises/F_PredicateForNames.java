package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class F_PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.valueOf(reader.readLine());

        List<String> list = Arrays
                .stream(reader.readLine().split(" ")).collect(Collectors.toList());

        list.stream()
                .filter(word -> word.length() <= size)
                .forEach(System.out::println);
    }
}
