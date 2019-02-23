package Exercise.b_CompanyRoster2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<Employee>> map = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String currentDepartment = tokens[3];
            String email;
            int age;

            Employee employee = null;

            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, currentDepartment);

                    break;
                case 5:
                    try {
                        age = Integer.parseInt(tokens[4]);
                        employee = new Employee(name, salary, currentDepartment, age);
                    }catch (Exception e) {
                        email = tokens[4];
                        employee = new Employee(name, salary, currentDepartment, email);
                    }
                    break;
                case 6:
                    email = tokens[4];
                    age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, currentDepartment, email, age);
                    break;
            }

            map.putIfAbsent(currentDepartment, new ArrayList<>());
            map.get(currentDepartment).add(employee);
        }

        String dpt = map
                .entrySet()
                .stream()
                .sorted((f, s) -> {
                    Double e1 = f.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
                    Double e2 = s.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble();

                    return Double.compare(e2, e1);
                })
                .findFirst().get().getKey();

        System.out.printf("Highest Average Salary: %s%n", dpt);

        map.get(dpt)
                .stream()
                .sorted((a, b) -> Integer.compare(a.getAge(), b.getAge()))
                .forEach(s -> System.out.printf("%s %.2f %s %d%n", s.getName(), s.getSalary(), s.getEmail(), s.getAge()));
    }
}
