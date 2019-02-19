package ingredient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity @Table(name = "teachers")
public class Teacher extends Person {
    private String speciality;

    public Teacher() {
        super();
    }

    public Teacher(String name, String speciality) {
        super(name);
        this.speciality = speciality;
    }

    @Column(name = "specialities")
    public String getSpeciality() {
        return this.speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
