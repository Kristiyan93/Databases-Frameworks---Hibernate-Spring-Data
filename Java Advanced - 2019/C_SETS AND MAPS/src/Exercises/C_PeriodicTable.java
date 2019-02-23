package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.TreeSet;

public class C_PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeSet<String> set = new TreeSet<>();

        int n = Integer.valueOf(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            Collections.addAll(set, tokens);
        }

        for (String word : set) {
            System.out.print(word + " ");
        }
    }
}
