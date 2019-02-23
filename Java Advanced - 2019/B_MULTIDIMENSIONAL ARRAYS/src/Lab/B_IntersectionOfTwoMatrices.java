package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_IntersectionOfTwoMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int row = Integer.valueOf(reader.readLine());
        int col = Integer.valueOf(reader.readLine());

        char[][] firstMatrix = new char[row][col];
        char[][] secondMatrix = new char[row][col];

        for (int i = 0; i < firstMatrix.length; i++) {
            String[] symbol = reader.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                firstMatrix[i][j] = symbol[j].charAt(0);
            }
        }

        for (int i = 0; i < secondMatrix.length; i++) {
            String[] symbol = reader.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                secondMatrix[i][j] = symbol[j].charAt(0);
            }
        }

        char[][] result = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    result[i][j] = '*';
                    continue;
                }

                result[i][j] = firstMatrix[i][j];
            }
        }

        getPrint(result);
    }

    private static void getPrint(char[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }

            System.out.println();
        }
    }
}
