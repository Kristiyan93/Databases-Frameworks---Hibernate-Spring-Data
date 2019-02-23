package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class E_Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, String> map = new HashMap<>();

        String input = reader.readLine();

        while (!input.equals("search")) {
            String[] tokens = input.split("-");

            String name = tokens[0];
            String phone = tokens[1];

            phone = map.containsKey(name) ? map.get(name) : phone;
            map.put(name, phone);

            input = reader.readLine();
        }

        input = reader.readLine();

        while (!input.equals("stop")) {
            if (map.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, map.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = reader.readLine();
        }
    }
}
