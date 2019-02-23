package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class A_ReverseNumbersWithAStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        ArrayDeque<Integer> stac = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            stac.push(Integer.valueOf(input[i]));
        }

        int size = stac.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stac.pop() + " ");
        }
    }
}
