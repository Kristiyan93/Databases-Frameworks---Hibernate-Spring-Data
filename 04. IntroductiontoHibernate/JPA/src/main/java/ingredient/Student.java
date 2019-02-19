package ingredient;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "registration_date")
    private Date brithDate;

    public Student() {
    }

    public Student(String name, Date brithDate) {
        setName(name);
        setBrithDate(brithDate);
    }

    public int getId() {
        return this.id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Date getBrithDate() {
        return this.brithDate;
    }

    private void setBrithDate(Date brithDate) {
        this.brithDate = brithDate;
    }
}
