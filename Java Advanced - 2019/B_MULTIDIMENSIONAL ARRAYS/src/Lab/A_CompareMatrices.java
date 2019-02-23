package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_CompareMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays
                .stream(reader.readLine().split("\\s"))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[][] matrix1 = new int[numbers[0]][numbers[1]];

        for (int i = 0; i < numbers[0]; i++) {
            int[] array = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            matrix1[i] = array;
        }

        int[] numbers2 = Arrays
                .stream(reader.readLine().split("\\s"))
                .mapToInt(Integer::valueOf)
                .toArray();

        int[][] matrix2 = new int[numbers2[0]][numbers2[1]];

        for (int i = 0; i < numbers2[0]; i++) {
            int[] array = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            matrix2[i] = array;
        }

        if (!matricesAreEqual(matrix1, matrix2)) {
            System.out.println("not equal");
            return;
        }

        System.out.println("equal");
    }

    static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        if (firstMatrix[0].length != secondMatrix[0].length) {
            return false;
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
