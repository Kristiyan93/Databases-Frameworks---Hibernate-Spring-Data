package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;

public class B_SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");

        Deque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            Integer firstDigit = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            Integer secondDigit = Integer.parseInt(stack.pop());

            switch (operator) {
                case "+":
                    stack.push(String.valueOf(firstDigit + secondDigit));
                    break;
                case "-":
                    stack.push(String.valueOf(firstDigit - secondDigit));
                    break;
                    default:
                        break;
            }
        }

        System.out.println(stack.pop());
    }
}
