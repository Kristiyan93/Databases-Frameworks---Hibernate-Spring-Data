package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class A_UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.valueOf(reader.readLine());

        LinkedHashSet<String> set = new LinkedHashSet<>();

        for (int i = 0; i < size; i++) {
            String user = reader.readLine();

            set.add(user);
        }

        for (String user : set) {
            System.out.println(user);
        }
    }
}
