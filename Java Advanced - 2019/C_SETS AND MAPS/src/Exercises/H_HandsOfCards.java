package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class H_HandsOfCards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        String input = reader.readLine();

        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");

            String name = tokens[0];
            String[] tokens2 = tokens[1].split(", ");

            int value = 0;
            //2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
            //S -> 4, H-> 3, D -> 2, C -> 1

            for (int i = 0; i < tokens2.length; i++) {
                String string = tokens2[i];
                int voul = 0;
                int power = 0;

                for (char ch : string.toCharArray()) {
                    if (Character.isDigit(ch)) {
                        voul = Integer.valueOf(ch);
                    }

                    switch (ch) {
                        case 'J':
                            voul = 11;
                            break;
                        case 'Q':
                            voul = 12;
                            break;
                        case 'K':
                            voul = 13;
                            break;
                        case 'A':
                            voul = 14;
                            break;
                        case 'S':
                            power = 4;
                            break;
                        case 'H':
                            power = 3;
                            break;
                        case 'D':
                            power = 2;
                            break;
                        case 'C':
                            power = 1;
                            break;
                            default:
                                break;
                    }

                    value = voul * power;
                }

                value = map.containsKey(name) ? map.get(name) : 0;
                map.put(name, value + 0);
            }

            input = reader.readLine();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
        }
    }
}
