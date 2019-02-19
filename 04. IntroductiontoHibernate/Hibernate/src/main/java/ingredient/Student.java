package ingredient;

import java.util.Date;

public class Student {
    private int id;
    private String name;
    private Date registrationDate;


    public Student() { }

    public Student(String name, Date date) {
        setName(name);
        setRegistrationDate(date);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
