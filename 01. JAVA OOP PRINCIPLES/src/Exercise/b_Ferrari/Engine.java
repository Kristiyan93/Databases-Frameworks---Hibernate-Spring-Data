package Exercise.b_Ferrari;

import java.util.Scanner;

public class Engine implements Runnable {
    private final Scanner scanner;

    public Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        String name = this.scanner.nextLine();

        Car ferrari = new Ferrari(name);

        System.out.printf("%s/%s/%s/%s%n", ferrari.getModel(), ferrari.brake()
                , ferrari.pushTheGas(), ferrari.getDriver());
    }
}
