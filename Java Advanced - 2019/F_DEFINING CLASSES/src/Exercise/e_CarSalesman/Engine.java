package Exercise.e_CarSalesman;

public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement =  "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = Integer.toString(displacement);
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = Integer.toString(displacement);
        this.efficiency = efficiency;
    }

    public String getModel() {
        return this.model;
    }

    public int getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
