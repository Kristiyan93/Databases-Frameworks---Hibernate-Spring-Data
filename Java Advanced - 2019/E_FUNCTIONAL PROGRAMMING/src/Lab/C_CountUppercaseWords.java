package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class C_CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] text = reader.readLine().split(" ");

        Predicate<String> isUpper = word -> word.charAt(0) == word.toUpperCase().charAt(0);

        List<String> filterText = Arrays.stream(text)
                .filter(isUpper)
                .collect(Collectors.toList());

        System.out.println(filterText.size());

        filterText.stream().forEach(System.out::println);
    }
}
