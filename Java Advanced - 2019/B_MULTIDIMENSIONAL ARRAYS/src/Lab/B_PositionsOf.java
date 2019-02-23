package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_PositionsOf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = Arrays
                .stream(reader.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
        
        int[][] matrix = new int[array[0]][array[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        }

        int search = Integer.valueOf(reader.readLine());
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == search) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
