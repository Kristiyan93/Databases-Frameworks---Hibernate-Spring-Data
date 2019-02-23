package Exercise.d_RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String type = tokens[4];
            double pressure1 = Double.parseDouble(tokens[5]);
            int age1 = Integer.parseInt(tokens[6]);
            double pressure2 = Double.parseDouble(tokens[7]);
            int age2 = Integer.parseInt(tokens[8]);
            double pressure3 = Double.parseDouble(tokens[9]);
            int age3 = Integer.parseInt(tokens[10]);
            double pressure4 = Double.parseDouble(tokens[11]);
            int age4 = Integer.parseInt(tokens[12]);

            Engine engine = new Engine(speed, power);
            Cargo cargo = new Cargo(weight, type);
            Tire tire = new Tire(pressure1, age1);
            Tire tire2 = new Tire(pressure2, age2);
            Tire tire3 = new Tire(pressure3, age3);
            Tire tire4 = new Tire(pressure4, age4);
            List<Tire> tires = new ArrayList<>();

            tires.add(tire);
            tires.add(tire2);
            tires.add(tire3);
            tires.add(tire4);

            cars.add(new Car(model, engine, cargo, tires));
        }

        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            cars.stream()
                    .filter(t -> t.getCargos().getType().equals(command))
                    .filter(Car::checkTiresP)
                    .forEach(c -> System.out.println(c.getModel()));
        } else {
            cars.stream()
                    .filter(t -> t.getCargos().getType().equals(command))
                    .filter(p -> p.getEngines().getPower() > 250)
                    .forEach(c -> System.out.println(c.getModel()));
        }
    }
}
