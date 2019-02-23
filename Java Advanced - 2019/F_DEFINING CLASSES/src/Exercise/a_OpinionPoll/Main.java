package Exercise.a_OpinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> people = new ArrayList<>();

        int n =Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            people.add(person);
        }

        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .filter(age -> age.getAge() > 30)
                .forEach(p -> System.out.printf("%s - %d%n", p.getName(), p.getAge()));
    }
}
