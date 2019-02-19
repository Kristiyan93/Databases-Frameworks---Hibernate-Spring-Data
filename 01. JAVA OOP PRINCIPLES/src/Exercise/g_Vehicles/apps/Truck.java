package Exercise.g_Vehicles.apps;

public class Truck implements Vehicle {
    private String type;
    private Double fuelQuantity;
    private Double litersPerKm;

    public Truck(String type, Double fuelQuantity, Double litersPerKm) {
        setType(type);
        setFuelQuantity(fuelQuantity);
        setLitersPerKm(litersPerKm);
    }

    private void setType(String type) {
        this.type = type;
    }

    private void setFuelQuantity(Double fuelQuantity) {
       if (fuelQuantity > 0) {
           this.fuelQuantity = fuelQuantity * 1.95;
       } else {
           throw new IllegalArgumentException("");
       }
    }

    private void setLitersPerKm(Double litersPerKm) {
        this.litersPerKm = litersPerKm + 1.6;
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
