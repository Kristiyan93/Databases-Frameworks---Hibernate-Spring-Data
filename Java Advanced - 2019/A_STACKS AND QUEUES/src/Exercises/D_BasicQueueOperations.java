package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class D_BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int n = arr[0];
        int s = arr[1];
        int x = arr[2];

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int[] input = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        for (int i = 0; i < n; i++) {
            deque.offer(input[i]);
        }

        for (int i = 0; i < s; i++) {
            deque.poll();
        }

        if (deque.isEmpty()) {
            System.out.println(0);
            return;
        }

        int small = Integer.MAX_VALUE;

        for (int i = 0; i < deque.size(); i++) {
            int digit = deque.poll();
            if (x == digit) {
                System.out.println("true");
                return;
            }

            if (digit < small) {
                small = digit;
            }

            deque.offer(digit);
        }

        System.out.println(small);
    }
}
