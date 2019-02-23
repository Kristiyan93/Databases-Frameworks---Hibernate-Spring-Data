package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class G_FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        String inputName = reader.readLine();

        while (!inputName.equals("stop")) {
            String inputEmail = reader.readLine();

            map.putIfAbsent(inputName, inputEmail);
            map.put(inputName, inputEmail);

            inputName = reader.readLine();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] tokens = entry.getValue().split("\\.");
            String end = tokens[1];
            if (end.equals("us") || end.equals("uk") || end.equals("com")) {
                continue;
            }

            System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
        }
    }
}
