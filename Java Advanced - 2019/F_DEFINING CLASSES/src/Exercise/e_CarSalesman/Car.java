package Exercise.e_CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = Integer.toString(weight);
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = Integer.toString(weight);
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.model).append(":\n")
                .append(engine.getModel()).append(":\n")
                .append("Power: ").append(this.engine.getPower()).append("\n")
                .append("Displacement: ").append(this.engine.getDisplacement()).append("\n")
                .append("Efficiency: ").append(this.engine.getEfficiency()).append("\n")
                .append("Weight: ").append(this.weight).append("\n")
                .append("Color: ").append(this.color);

        return sb.toString();
    }
}
