package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class E_ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays
                .stream(reader.readLine().split(" "))
                .map(Integer::new)
                .collect(Collectors.toList());

        int n = Integer.valueOf(reader.readLine());

        list = list.stream()
                .filter(x -> x % n != 0)
                .collect(Collectors.toList());

        Collections.reverse(list);

        list.stream().forEach(x -> System.out.printf("%d ", x));
    }
}
