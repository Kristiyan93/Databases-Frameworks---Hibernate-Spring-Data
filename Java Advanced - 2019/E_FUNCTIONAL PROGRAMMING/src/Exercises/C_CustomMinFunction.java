package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C_CustomMinFunction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf).toArray();

        int digit = Arrays.stream(arr).min().getAsInt();

        System.out.println(digit);
    }
}
