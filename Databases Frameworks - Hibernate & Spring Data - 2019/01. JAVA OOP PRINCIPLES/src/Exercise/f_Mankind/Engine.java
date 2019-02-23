package Exercise.f_Mankind;

import Exercise.f_Mankind.apps.Human;
import Exercise.f_Mankind.apps.Student;
import Exercise.f_Mankind.apps.Worker;

import java.util.Scanner;

public class Engine implements Runnable {
    private final Scanner scanner;

    public Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        String[] st = this.scanner.nextLine().split(" ");
        String[] wr = this.scanner.nextLine().split(" ");

        try {
            Human student = new Student(st[0], st[1], st[2]);
            Human worker = new Worker(wr[0], wr[1], Double.parseDouble(wr[2]), Double.parseDouble(wr[3]));

            System.out.println(student.toString());
            System.out.println(worker.toString());
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
