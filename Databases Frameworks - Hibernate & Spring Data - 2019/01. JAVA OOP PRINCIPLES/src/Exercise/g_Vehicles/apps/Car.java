package Exercise.g_Vehicles.apps;

public class Car implements Vehicle {
    private Double travel = 0.0;
    private String type;
    private Double fuelQuantity;
    private Double litersPerKm;

    public Car(String type, Double fuelQuantity, Double litersPerKm) {
        setType(type);
        setFuelQuantity(fuelQuantity);
        setLitersPerKm(litersPerKm);
    }

    public void setTravel(Double travel) {
        this.travel = travel;
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setFuelQuantity(Double fuelQuantity) {
        if (fuelQuantity > 0) {
            this.fuelQuantity = fuelQuantity;
        } else {
            throw new IllegalArgumentException("");
        }
    }

    private void setLitersPerKm(Double litersPerKm) {
        this.litersPerKm = litersPerKm + 0.9;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Double getFuelQuantity() {
        return this.fuelQuantity;
    }

    @Override
    public Double getLitersPerKm() {
        return this.litersPerKm;
    }
}
