package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D_MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        int rows = arr[0];
        int cols = arr[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays
                    .stream(reader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        int sum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        int[][] result = new int[3][3];

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                Integer curentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (curentSum > sum) {
                    sum = curentSum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.println("Sum = " + sum);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i + startRow][j + startCol] + " ");
            }

            System.out.println();
        }
    }
}
