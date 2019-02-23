package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class F_AMinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equals("stop")) {
            int quantity = Integer.valueOf(reader.readLine());

            int count = map.containsKey(input) ? map.get(input) : 0;
            map.put(input, quantity + count);

            input = reader.readLine();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String resource = entry.getKey();
            int quantity = entry.getValue();

            System.out.printf("%s -> %d%n", resource, quantity);
        }
    }
}
