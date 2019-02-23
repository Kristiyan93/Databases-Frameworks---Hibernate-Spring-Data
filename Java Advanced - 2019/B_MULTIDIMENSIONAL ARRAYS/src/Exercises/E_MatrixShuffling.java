package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class E_MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        int rows = arr[0];
        int cols = arr[1];

        String[][]matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = reader.readLine().split(" ");
        }

        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");

            try {
                int a = Integer.valueOf(tokens[1]);
                int b = Integer.valueOf(tokens[2]);

                int c = Integer.valueOf(tokens[3]);
                int d = Integer.valueOf(tokens[4]);

                String digitAB = matrix[a][b];
                String digitCD = matrix[c][d];

                matrix[c][d] = digitAB;
                matrix[a][b] = digitCD;

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }

                    System.out.println();
                }

            } catch (Exception e) {
                System.out.println("Invalid input!");
            }

            input = reader.readLine();
        }
    }
}
