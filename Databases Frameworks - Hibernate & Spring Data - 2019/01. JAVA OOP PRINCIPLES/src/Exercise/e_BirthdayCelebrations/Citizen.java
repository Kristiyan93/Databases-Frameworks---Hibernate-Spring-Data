package Exercise.e_BirthdayCelebrations;

public class Citizen extends Celebration {
    private int age;
    private String id;

    public Citizen(String name, Integer age,  String id, String date) {
        super(name, date);
        this.age = age;
        this.id = id;
    }
}
