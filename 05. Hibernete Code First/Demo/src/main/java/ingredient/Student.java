package ingredient;

import javax.persistence.*;

@Entity @Table(name = "students")
public class Student extends Person {
    private int grade;

    public Student() {
        super();
    }

    public Student(String name, int grade) {
        super(name);
        this.grade = grade;
    }

    @Column(name = "grade")
    public int getGrade() {
        return this.grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
