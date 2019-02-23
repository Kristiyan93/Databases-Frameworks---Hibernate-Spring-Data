package Exercise.f_Mankind.apps;

public class Student extends Human {
    private String faculty;

    public Student(String firstName, String lastName, String faculty) {
        super(firstName, lastName);
        setFaculty(faculty);
    }

    public void setFaculty(String faculty) {
        if (faculty.length() < 5 || faculty.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.faculty = faculty;
    }

    public String getFaculty() {
        return this.faculty;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s%n" +
                        "Last Name: %s%n" +
                        "Faculty number: %s%n", this.getFirstName()
                , this.getLastName(), this.getFaculty());
    }
}
