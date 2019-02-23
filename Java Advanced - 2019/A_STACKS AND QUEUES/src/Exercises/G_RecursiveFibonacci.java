package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class G_RecursiveFibonacci {
    public static void main(String[] args) throws IOException {
        int t1  = 0;
        int t2 = 1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> dequeFibonacci = new ArrayDeque<>();

        dequeFibonacci.offer(1);

        for (int i = 0; i < 49; i++) {
            int sum = t1 + t2;
            t1 = t2;
            t2 = sum;
            if (sum > 0) {
                dequeFibonacci.offer(sum);
            }
        }

        try {
            int n = Integer.valueOf(reader.readLine());

            for (int i = 0; i < n; i++) {
                dequeFibonacci.poll();
            }

            System.out.println(dequeFibonacci.peek());
        } catch (Exception e) {}
    }
}
