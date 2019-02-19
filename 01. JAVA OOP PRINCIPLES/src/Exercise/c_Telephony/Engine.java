package Exercise.c_Telephony;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final Scanner scanner;

    public Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        List<Smartphone> smartphones = new ArrayList<>();
        List<Browse> browses = new ArrayList<>();

        String[] phones = this.scanner.nextLine().split(" ");
        String[] webs = this.scanner.nextLine().split(" ");

        for (String s : phones) {
            smartphones.add(new Smartphone(s));
        }

        for (String web : webs) {
            browses.add(new Browse(web));
        }

        Telephony telephony = new Telephony();

        for (Smartphone s : smartphones) {
            telephony.getSmartphones().add(s);
        }

        for (Browse w : browses) {
            telephony.getBrowses().add(w);
        }

        telephony.getSmartphones().forEach(s -> {
            if (s.getPhone().equals("Invalid number!")) {
                System.out.println(s.getPhone());
            } else {
                System.out.println("Calling... " + s.getPhone());
            }
        });

        telephony.getBrowses().forEach(b ->{
            if (b.getWeb().equals("Invalid URL!")) {
                System.out.println(b.getWeb());
            } else {
                System.out.println("Browsing: " + b.getWeb() + "!");
            }
        });
    }
}
