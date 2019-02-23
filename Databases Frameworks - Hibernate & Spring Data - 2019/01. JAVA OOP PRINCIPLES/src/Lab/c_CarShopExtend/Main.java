package Lab.c_CarShopExtend;

import Lab.c_CarShopExtend.cars.Audi;
import Lab.c_CarShopExtend.cars.Seat;
import Lab.c_CarShopExtend.interfaces.Car;
import Lab.c_CarShopExtend.interfaces.Rentable;
import Lab.c_CarShopExtend.interfaces.Sellable;

public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("Audi", "Black", 136, "Bg", 3, 99.9);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }
}
