package Exercise.b_CompanyRoster;

public class Employee {
    private static final String EMAIL_DEF_VALUE = "n/a";
    private static final  int AGE_DEF_VALUE = -1;

    private String name;
    private double salary;
    private String email;
    private int age;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.email = EMAIL_DEF_VALUE;
        this.age = AGE_DEF_VALUE;
    }

    public Employee(String name, double salary, String email) {
        this(name, salary);
        this.email = email;
    }

    public Employee(String name, double salary, int age) {
        this(name, salary);
        this.age = age;
    }

    public Employee(String name, double salary, String email, int age) {
        this(name, salary, email);
        this.age = age;
    }

    public Double getSalary() {
        return this.salary;
    }

    public int getAge() {
        return this.age;
    }

    public String getInfo() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
