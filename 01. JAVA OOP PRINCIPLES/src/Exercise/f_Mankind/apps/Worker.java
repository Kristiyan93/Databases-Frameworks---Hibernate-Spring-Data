package Exercise.f_Mankind.apps;

public class Worker extends Human {
    private Double salary;
    private Double hoursPerDay;

    public Worker(String firstName, String lastName, Double salary, Double hoursPerDay) {
        super(firstName, lastName);
        setSalary(salary);
        setHoursPerDay(hoursPerDay);
    }

    public Double getSalary() {
        return this.salary;
    }

    private void setSalary(Double salary) {
        if (salary < 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }

        this.salary = salary;
    }

    public Double getHoursPerDay() {
        return this.hoursPerDay;
    }

    private void setHoursPerDay(Double hoursPerDay) {
        if (hoursPerDay < 1 || hoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }

        this.hoursPerDay = hoursPerDay;
    }

    public Double getSalaryPerHours() {
        return this.getSalary() / (this.getHoursPerDay() * 7.0);
    }

    @Override
    public String toString() {
        return String.format("First Name: %s\n" +
                        "Last Name: %s\n" +
                        "Week Salary: %.2f\n" +
                        "Hours per day: %.2f\n" +
                        "Salary per hour: %.2f\n", this.getFirstName(), this.getLastName()
                , this.getSalary(), this.getHoursPerDay()
                , this.getSalaryPerHours());
    }
}
