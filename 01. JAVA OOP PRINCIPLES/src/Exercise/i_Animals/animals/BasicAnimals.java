package Exercise.i_Animals.animals;

import Exercise.i_Animals.interfaces.Animals;

public abstract class BasicAnimals implements Animals {
    private String name;
    private int age;
    private String gender;

    public BasicAnimals(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s", this.getClass().getSimpleName(), this.name
                , this.age, this.gender);
    }
}
