package ingredient;

import javax.persistence.*;

@Entity @Table(name =  "persons")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    public Person() { }

    public Person(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(
            name = "name"
            , length = 50
            , nullable = false
    )
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
