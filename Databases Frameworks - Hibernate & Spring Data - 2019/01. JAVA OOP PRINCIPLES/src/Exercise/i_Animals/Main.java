package Exercise.i_Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Runnable runnable = new Running(scanner);

        runnable.run();
    }
}
