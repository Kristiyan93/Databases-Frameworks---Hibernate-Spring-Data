package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class C_DecimalToBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int digit = Integer.parseInt(reader.readLine());

        if (digit == 0) {
            System.out.println(digit);
            return;
        }

        while (digit != 0) {
            stack.push(digit % 2);
            digit /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
