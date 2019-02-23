package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class G_FindTheSmallestElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::new)
                .collect(Collectors.toList());

        int index = 0;
        int minNum = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            int d = list.get(i);

            if (minNum >= d) {
                minNum = d;
                index = i;
            }
        }

        System.out.println(index);
    }
}
