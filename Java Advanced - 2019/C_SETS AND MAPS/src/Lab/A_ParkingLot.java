package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class A_ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> parking = new HashSet<>();

        String input = reader.readLine();

        while (!input.equals("END")) {
            String[] token = input.split(", ");

            if (token[0].equalsIgnoreCase("in")) {
                parking.add(token[1]);
            }
            if (token[0].equalsIgnoreCase("out")) {
                parking.remove(token[1]);
            }

            input = reader.readLine();
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        }

        for (String number : parking) {
            System.out.println(number);
        }
    }
}
