package Exercises;
//50/100
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class F_BalancedParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if (input.length() % 2 != 0) {
            System.out.println("No");
            return;
        }

        boolean isBalance = true;

        for (int i = 0; i < input.length() / 2; i++) {
            char symbol = input.charAt(i);

            switch (symbol) {
                case '(':
                    if (input.charAt(input.length() - 1 - i) != ')') {
                        isBalance = false;
                    }
                    break;
                case '{':
                    if (input.charAt(input.length() - 1 - i) != '}') {
                        isBalance = false;
                    }
                    break;
                case '[':
                    if (input.charAt(input.length() - 1 - i) != ']') {
                        isBalance = false;
                    }
                    break;
            }
        }

        if (isBalance) {
            System.out.println("YES");
            return;
        }

        System.out.println("NO");
    }
}
