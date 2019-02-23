package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class D_AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Double> list = Arrays
                .stream(reader.readLine().split(", "))
                .map(Double::valueOf)
                .collect(Collectors.toList());

        UnaryOperator<Double> addVat = x -> x * 1.2;

        System.out.println("Prices with VAT:");

        list.stream().map(addVat).forEach(a -> System.out.printf("%.2f%n", a));
    }
}
