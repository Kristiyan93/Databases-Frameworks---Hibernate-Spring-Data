package Exercise.e_CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        addEnginee(scanner, engines, n);

        n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Car car = getCar(scanner, engines);

            System.out.println(car.toString());
        }
    }

    private static Car getCar(Scanner scanner, List<Engine> engines) {
        String[] tokens = scanner.nextLine().split("\\s+");
        String model = tokens[0];
        String currentEngine = tokens[1];
        Engine engine = null;
        Car car = null;

        for (int j = 0; j < engines.size(); j++) {
            if (engines.get(j).getModel().equals(currentEngine)) {
                engine = engines.get(j);
            }
        }

        switch (tokens.length) {
            case 2:
                car = new Car(model, engine);
                break;
            case 3:
                try {
                    car = new Car(model, engine, Integer.parseInt(tokens[2]));
                }catch (Exception e) {
                    car = new Car(model, engine, tokens[2]);
                }
                break;
            case 4:
                car = new Car(model, engine, Integer.parseInt(tokens[2]), tokens[3]);
                break;
        }
        return car;
    }

    private static void addEnginee(Scanner scanner, List<Engine> engines, int n) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Engine engine = null;

            switch (tokens.length) {
                case 2:
                    engine = new Engine(tokens[0], Integer.parseInt(tokens[1]));
                    engines.add(engine);
                    break;
                case 3:
                    try {
                        engine = new Engine(tokens[0], Integer.parseInt(tokens[1])
                                , Integer.parseInt(tokens[2]));
                        engines.add(engine);
                    }catch (Exception e) {
                        engine = new Engine(tokens[0], Integer.parseInt(tokens[1])
                                , tokens[2]);
                        engines.add(engine);
                    }
                    break;
                case 4:
                    engine = new Engine(tokens[0], Integer.parseInt(tokens[1])
                            , Integer.parseInt(tokens[2]), tokens[3]);
                    engines.add(engine);
                    break;
            }
        }
    }
}
