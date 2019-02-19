package Exercise.g_Vehicles;

import Exercise.g_Vehicles.apps.Car;
import Exercise.g_Vehicles.apps.Truck;
import Exercise.g_Vehicles.apps.Vehicle;

import java.util.Scanner;

public class Engine implements Runnable {
    private final Scanner scanner;

    public Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        String[] carTokens = this.scanner.nextLine().split(" ");
        String[] truckTokens = this.scanner.nextLine().split(" ");

        Vehicle car = new Car(carTokens[0], Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        Vehicle truck = new Truck(truckTokens[0], Double.parseDouble(truckTokens[1]), Double.parseDouble(truckTokens[2]));

        Integer n = this.scanner.nextInt();

        while (n-- > 0) {
            String[] tokens = this.scanner.nextLine().split(" ");
            Double distance = Double.parseDouble(tokens[2]);

            switch (tokens[1]) {
                case "Car":
                    if (tokens[0].equals("Drive")) {

                    }

                    if (tokens[0].equals("Refuel")) {

                    }

                    break;
                case "Truck":
                    if (tokens[0].equals("Drive")) {

                    }

                    if (tokens[0].equals("Refuel")) {

                    }

                    break;
            }
        }
    }
}
