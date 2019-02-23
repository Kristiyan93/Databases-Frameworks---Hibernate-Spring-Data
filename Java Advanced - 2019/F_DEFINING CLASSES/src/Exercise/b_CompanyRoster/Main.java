package Exercise.b_CompanyRoster;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Department> departments = new HashMap<>();

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
                    employee = new Employee(name, salary);
                    break;
                case 5:
                    if (tokens[4].contains("@")) {
                        email = tokens[4];
                        employee = new Employee(name, salary, email);
                        break;
                    }

                    age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, age);
                    break;
                default:
                    email = tokens[4];
                    age = Integer.parseInt(tokens[5]);
                    employee = new Employee(name, salary, email, age);
            }

            departments.putIfAbsent(currentDepartment, new Department(currentDepartment));
            departments.get(currentDepartment).getEmployees().add(employee);
        }

        String dpt = departments
                .entrySet()
                .stream()
                .sorted((a, b) -> Double.compare(b.getValue().getAvgSalary(), a.getValue().getAvgSalary()))
                .findFirst().get().getKey();

        System.out.printf("Highest Average Salary: %s%n", dpt);

        departments.get(dpt).getEmployees()
                .stream()
                .sorted((a, b) -> b.getSalary().compareTo(a.getSalary()))
                .forEach(e ->System.out.println(e.getInfo()));

    }
}
