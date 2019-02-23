package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class B_SetsOfElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < arr[0]; i++) {
            int digit = Integer.valueOf(reader.readLine());

            set1.add(digit);
        }

        for (int i = 0; i < arr[1]; i++) {
            int digit = Integer.valueOf(reader.readLine());

            set2.add(digit);
        }

        //boolean isContain = false;

        if (set1.size() >= set2.size()) {
            for (Integer n : set2) {
                if (set1.contains(n)) {
                    System.out.print(n + " ");
          //          isContain = true;
                }
            }
        }

        if (set2.size() > set1.size()){
            for (Integer n : set1) {
                if (set2.contains(n)) {
                    System.out.println(n + " ");
            //        isContain = true;
                }
            }
        }
    }
}
