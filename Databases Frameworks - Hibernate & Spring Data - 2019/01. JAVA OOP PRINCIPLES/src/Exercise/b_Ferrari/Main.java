package Exercise.b_Ferrari;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Runnable runnable = new Engine(scanner);

        runnable.run();
    }
}
