package Exercise.b_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public double getAvgSalary() {
        return employees.stream().mapToDouble(Employee::getSalary)
                .average().getAsDouble();
    }
}
