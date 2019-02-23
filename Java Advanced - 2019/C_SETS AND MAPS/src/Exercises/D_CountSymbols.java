package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class D_CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Character, Integer> map = new TreeMap<>();

        String text = reader.readLine();

        for (char ch : text.toCharArray()) {
            int count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char s = entry.getKey();
            int d = entry.getValue();

            System.out.printf("%c: %d time/s%n", s, d);
        }
    }
}
