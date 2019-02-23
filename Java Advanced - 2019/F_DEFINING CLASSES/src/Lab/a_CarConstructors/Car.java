package Lab.a_CarConstructors;

public class Car {
    private static final String UNKNOWN_MAKE = "unknown";
    private static final Integer UNKNOWN_HP = -1;

    private String make;
    private String model;
    private Integer horsePower;

    public Car(String make) {
        setMake(make);
        setModel(UNKNOWN_MAKE);
        setHorsePower(UNKNOWN_HP);
    }

    public Car(String make, String model) {
        this(make);
        setModel(model);
        setHorsePower(UNKNOWN_HP);
    }

    public Car(String make, Integer horsePower) {
        this.make = make;
        setModel(UNKNOWN_MAKE);
        setHorsePower(horsePower);
    }

    public Car(String make, String model, Integer horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    private void setMake(String make) {
        this.make = make;
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", getMake(), getModel(), getHorsePower());
    }
}
