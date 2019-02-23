package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class E_Robotics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<String> robots = new ArrayDeque<>();
        ArrayDeque<Integer> times = new ArrayDeque<>();

        String[] tokens = reader.readLine().split(";");

        for (int i = 0; i < tokens.length; i++) {
            String[] tokens2 = tokens[i].split("-");

            robots.offer(tokens2[0]);
            times.offer(Integer.valueOf(tokens2[1]));
        }

        String[] timeTokens = reader.readLine().split(":");

        int h = Integer.valueOf(timeTokens[0]);
        int m = Integer.valueOf(timeTokens[1]);
        int s = Integer.valueOf(timeTokens[2]);

        String command = reader.readLine();

        ArrayDeque<String> products = new ArrayDeque<>();

        while (!command.equals("End")) {
            products.offer(command);

            command = reader.readLine();
        }

        int currentSec = 0;

        while (!products.isEmpty()) {
            currentSec++;

            for (int i = 0; i < robots.size(); i++) {
                String produc = products.poll();
                String robot = robots.poll();
                int time = times.poll();

                s++;

                if (s >= 59) {
                    m++;
                    s = 0;
                }

                if (m >= 59) {
                    h++;
                    m = 0;
                }

                String currentTime = String.format("[%02d:%02d:%02d]%n", h, m, s);

                System.out.printf("%s - %s %s", robot, time, currentTime);

                robots.offer(robot);
                times.offer(time);
            }
        }
    }
}
