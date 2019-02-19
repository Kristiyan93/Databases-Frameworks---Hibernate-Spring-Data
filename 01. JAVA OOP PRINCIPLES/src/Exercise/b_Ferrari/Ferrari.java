package Exercise.b_Ferrari;

public class Ferrari implements Car {
    private String name;

    public Ferrari(String name) {
        this.name = name;
    }

    @Override
    public String getModel() {
        return MODEL;
    }

    @Override
    public String brake() {
        return "Brakes!";
    }

    @Override
    public String pushTheGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String getDriver() {
        return this.name;
    }
}
