package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A_FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(", ");

        int rows = Integer.valueOf(tokens[0]);
        char type = tokens[1].charAt(0);

        int[][] matrix = new int[rows][rows];

        getCalculate(rows, type, matrix);
    }

    private static void getCalculate(int rows, char type, int[][] matrix) {
        int counter = 1;

        if (type == 'A') {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    matrix[j][i] = counter++;
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(matrix[i][j] + " ");
                }

                System.out.println();
            }
        }

        if (type == 'B') {
            for (int i = 0; i < rows; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < rows; j++) {
                        matrix[j][i] = counter++;
                    }
                } else {
                    for (int j = rows - 1; j >= 0; j--) {
                        matrix[j][i] = counter++;
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(matrix[i][j] + " ");
                }

                System.out.println();
            }
        }
    }
}
