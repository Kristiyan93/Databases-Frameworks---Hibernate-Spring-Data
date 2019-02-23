package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class E_PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> deque = new ArrayDeque<>();

        String input = reader.readLine();

        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                if (deque.isEmpty()) {
                    System.out.println("Printer is on standby");

                    input = reader.readLine();
                    continue;
                }

                System.out.println("Canceled " + deque.poll());

                input = reader.readLine();
                continue;
            }

            deque.offer(input);
            input = reader.readLine();
        }

        while (!deque.isEmpty()) {
            System.out.println(deque.poll());
        }
    }
}
