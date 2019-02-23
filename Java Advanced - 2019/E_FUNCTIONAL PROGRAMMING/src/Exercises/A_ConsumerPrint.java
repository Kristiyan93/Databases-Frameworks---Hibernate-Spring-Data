package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class A_ConsumerPrint {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Consumer<String> getPrint = w -> System.out.println(w);

        List<String> input = Arrays
                .stream(reader.readLine().split(" "))
                .collect(Collectors.toList());

        input.stream().forEach(getPrint);
    }
}
