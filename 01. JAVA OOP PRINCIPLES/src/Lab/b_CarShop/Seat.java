package Lab.b_CarShop;

public class Seat implements Car {
    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;

    public Seat(String model, String color, int hp, String countryProduced) {
        setModel(model);
        setColor(color);
        setHorsePower(hp);
        setCountryProduced(countryProduced);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public void setCountryProduced(String countryProduced) {
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getHorsePower() {
        return String.valueOf(this.horsePower);
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %d tires"
                , this.model, this.color, TIRES);
    }
}
