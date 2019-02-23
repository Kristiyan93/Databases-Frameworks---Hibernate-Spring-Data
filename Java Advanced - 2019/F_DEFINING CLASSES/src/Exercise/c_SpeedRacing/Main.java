package Exercise.c_SpeedRacing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostFor1km = Double.parseDouble(tokens[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1km);

            cars.put(model, car);
        }

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String model = tokens[1];
            int dist = Integer.parseInt(tokens[2]);

            try {
                cars.get(model).drive(dist);
            }catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            input = scanner.nextLine();
        }

        cars.entrySet().stream()
                .forEach(c -> System.out.println(c.getValue().toString()));
    }
}
