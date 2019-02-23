package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class B_BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        int n = Integer.valueOf(tokens[0]);
        int s = Integer.valueOf(tokens[1]);
        int x = Integer.valueOf(tokens[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        String[] numbers = reader.readLine().split("\\s+");

        for (int i = 0; i < n; i++) {
            stack.push(Integer.valueOf(numbers[i]));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < stack.size(); i++) {
            int digit = stack.pop();
            if (x == digit) {
                System.out.println("true");
                return;
            }

            if (smallest > digit) {
                smallest = digit;
            }

            stack.offer(digit);
        }

        System.out.println(smallest);
    }
}
