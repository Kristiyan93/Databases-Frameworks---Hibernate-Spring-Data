package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;

public class G_MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split("\\s+");
        int start = Integer.valueOf(reader.readLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, tokens);

        while (queue.size() > 1) {

        }

        System.out.println("Last is " + queue.poll());

    }
}
