package Exercise.c_SpeedRacing;

public class Car {
    private String model;
    private double fuelAmaount;
    private double fuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmaount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmaount = fuelAmaount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return this.model;
    }

    public void drive(int distance) {
        double needFueld = this.fuelCostFor1km * distance;

        if (fuelAmaount >= needFueld) {
            this.fuelAmaount -= needFueld;
            this.distanceTraveled += distance;
        } else {
            throw new IllegalArgumentException("Insufficient fuel for the drive");
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmaount, this.distanceTraveled);
    }
}
