package Exercise.a_DefineAnInterfacePerson.apps;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Engine implements Runnable {
    private final Scanner scanner;

    public Engine(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run() {
        String name = this.scanner.nextLine();
        int age = Integer.parseInt(this.scanner.nextLine());

        Person person = new Citizen(name, age);

        Method[] fields = Person.class.getDeclaredMethods();

        System.out.println(fields.length);
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
