package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class C_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            try {
                int command = Integer.valueOf(tokens[0]);

                switch (command) {
                    case 1:
                        stack.push(Integer.valueOf(tokens[1]));
                        break;
                    case 2:
                        stack.pop();
                        break;
                    case 3:
                        int maxNum = Integer.MIN_VALUE;

                        for (int j = 0; j < stack.size(); j++) {
                            int digit = stack.pop();
                            if (digit > maxNum) {
                                maxNum = digit;
                            }

                            stack.offer(digit);
                        }

                        System.out.println(maxNum);
                        break;
                        
                        default:
                            break;
                }
            } catch (Exception e) {}
        }
    }
}
