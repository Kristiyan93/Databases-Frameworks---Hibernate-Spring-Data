package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class A_SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       // List<Integer> list = Arrays.stream(reader.readLine().split(", ")).map(Integer::valueOf).collect(Collectors.toList());

        String[] input = reader.readLine().split(", ");

        List<Integer> list =  Arrays.stream(input)
                .map(Integer::valueOf)
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        String nums =  String.join(", ", list.toString());
        System.out.println(nums.substring(1, nums.length() - 1));

        list.sort(Integer::compareTo);
        String numSot = String.join(", ", list.toString());
        System.out.println(numSot.substring(1, numSot.length() - 1));
    }
}
