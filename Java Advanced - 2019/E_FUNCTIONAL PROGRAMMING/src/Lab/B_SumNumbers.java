package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class B_SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> input = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());

        Function<String, Integer> parse = Integer::valueOf;

        System.out.println("Count = " + input.size());

        int sum = input.stream().map(parse).reduce(0, (a, b) -> a + b);

        System.out.println("Sum = " + sum);
    }
}
