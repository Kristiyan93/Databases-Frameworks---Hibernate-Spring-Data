package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C_DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(reader.readLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays
                    .stream(reader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j <= i; j++) {
                primaryDiagonal += matrix[i][j];
                secondaryDiagonal += matrix[i][matrix.length - j - 1];
            }
        }

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }
}
