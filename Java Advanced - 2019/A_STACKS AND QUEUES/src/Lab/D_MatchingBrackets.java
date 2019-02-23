package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class D_MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '(') {
                stack.push(i);
        }
            else if (ch == ')') {
                int startIndex = stack.pop();
                String contents = input.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }
    }
}
