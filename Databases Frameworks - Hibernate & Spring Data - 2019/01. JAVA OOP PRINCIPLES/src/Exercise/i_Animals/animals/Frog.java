package Exercise.i_Animals.animals;

public class Frog extends BasicAnimals {
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Frogggg";
    }
}
