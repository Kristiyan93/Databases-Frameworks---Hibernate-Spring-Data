package Exercise.b_CompanyRoster2;

public class Employee {
    private String name;
    private double salary;
    private String department;
    private String email;
    private int age;

    public Employee(String department) {
        this.department = department;
    }

    public Employee(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.email = "n/a";
        this.age = -1;
    }

    public Employee(String name, double salary, String department, String email) {
        this(name, salary, department);
        this.email = email;
    }

    public Employee(String name, double salary, String department, int age) {
        this(name, salary, department);
        this.age = age;
    }

    public Employee(String name, double salary, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public double getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return  this.email;
    }
}
