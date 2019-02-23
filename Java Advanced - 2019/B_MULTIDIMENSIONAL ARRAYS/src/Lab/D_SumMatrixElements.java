package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] size = reader.readLine().split(", ");
        int rows = Integer.valueOf(size[0]);
        int cols = Integer.valueOf(size[1]);

        String[] elements = reader.readLine().split(", ");

       // int[][] matrix = matrixReader(elements, rows, cols);

        int count = 0;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.valueOf(elements[count]);
                count++;
            }
        }

        System.out.println(rows);
        System.out.println(cols);

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println(sum);
    }

    private static int[][] matrixReader(String[] elements, int rows, int cols) {
        int count = 0;
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.valueOf(elements[count]);
                count++;
            }
        }

        return matrix;
    }
}
