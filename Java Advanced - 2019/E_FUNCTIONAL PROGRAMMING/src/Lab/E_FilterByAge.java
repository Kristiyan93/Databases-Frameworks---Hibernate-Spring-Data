package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class E_FilterByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(", ");
            String name = tokens[0];
            int age = Integer.valueOf(tokens[1]);

            map.putIfAbsent(name, 0);
            map.put(name, age);
        }

        String condition = reader.readLine();
        int age = Integer.valueOf(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer = createPrinter(format);


    }

    private static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
        switch (format) {
            case "name age":
                return map -> System.out.printf("%s - %d%n", map.getKey(), map.getValue());
            case "name":
                return map -> System.out.printf("%s%n", map.getKey());
            case "age":
                return  map -> System.out.printf("%d", map.getValue());
        }

        return null;
    }

    private static Predicate<Integer> createTester(String condition, int age) {
        switch (condition) {
            case "younger":
                return x -> x < age;
            case "older":
                return x -> x >= age;
        }

        return null;
    }
}
