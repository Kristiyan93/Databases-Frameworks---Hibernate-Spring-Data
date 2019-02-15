package Lab.d_SayHello;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Bulgarian("Kris"));
        people.add(new Chinese("Elena"));
        people.add(new European("Denis"));

        for (Person p : people) {
            System.out.println(p.getName() + " " + p.sayHello());
        }
    }
}
