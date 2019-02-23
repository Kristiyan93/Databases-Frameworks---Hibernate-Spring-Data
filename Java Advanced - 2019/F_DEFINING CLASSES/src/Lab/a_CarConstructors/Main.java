package Lab.a_CarConstructors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Car car = null;
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String make = tokens[0];
            String model;
            int hp;

            switch (tokens.length) {
                case 1:
                    car = new Car(make);
                    break;
                case 2:
                    try {
                        hp = Integer.parseInt(tokens[1]);
                        car = new Car(make, hp);
                        break;
                    }catch (Exception e) {
                        model = tokens[1];
                        car = new Car(make, model);
                        break;
                    }
                case 3:
                    model = tokens[1];
                    hp = Integer.parseInt(tokens[2]);

                    car = new Car(make, model, hp);
                    break;
            }

            cars.add(car);
        }

        for (Car c : cars) {
            System.out.println(c.toString());
        }
    }
}
