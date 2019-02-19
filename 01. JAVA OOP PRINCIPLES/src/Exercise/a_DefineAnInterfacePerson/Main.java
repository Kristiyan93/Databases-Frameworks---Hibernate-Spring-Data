package Exercise.a_DefineAnInterfacePerson;

import Exercise.a_DefineAnInterfacePerson.apps.Engine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Runnable runnable = new Engine(scanner);

        runnable.run();
    }
}
