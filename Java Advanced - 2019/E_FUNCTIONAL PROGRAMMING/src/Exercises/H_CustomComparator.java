package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class H_CustomComparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::new)
                .collect(Collectors.toList());

        list.stream().sorted().forEach(x -> System.out.printf("%d ", x));
    }
}
