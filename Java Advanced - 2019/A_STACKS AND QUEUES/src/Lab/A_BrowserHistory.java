package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A_BrowserHistory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        String current = "";

        while (!input.equals("home")) {
            if(input.equals("back")){
                if(!stack.isEmpty()) {
                    current = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = reader.readLine();
                    continue;
                }
            } else {
                if(!current.equals("")) {
                    stack.push(current);
                }

                current = input;
            }

            System.out.println(current);
            input = reader.readLine();
        }

        for (int i = 0; i < stack.size(); i++) {
            System.out.println(stack.pop());
        }
    }
}
