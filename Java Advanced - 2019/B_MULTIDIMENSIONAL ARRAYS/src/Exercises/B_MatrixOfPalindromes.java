package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        String[][] matrix = new String[arr[0]][arr[1]];

        getResult(arr, matrix);
    }

    private static void getResult(int[] arr, String[][] matrix) {
        int row = arr[0];
        int col = arr[1];

        char[] letters = {'a', 'a', 'a'};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                letters[0] += i;
                letters[1] += j;
                letters[2] += i;

                StringBuilder sb = new StringBuilder();
                sb.append(letters[0]);
                sb.append(letters[1]);
                sb.append(letters[2]);

                matrix[i][j] = sb.toString();
                letters[0] -= i;
                letters[1] -= j;
                letters[2] -= i;
            }

            letters[1] += 1;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
}
