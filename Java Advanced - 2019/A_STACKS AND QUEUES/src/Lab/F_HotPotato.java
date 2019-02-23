package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class F_HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        int start = Integer.valueOf(reader.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, tokens);

        while (queue.size() > 1) {
            for (int i = 1; i < start; i++) {
                queue.offer(queue.poll());
            }

            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());

    }
}
