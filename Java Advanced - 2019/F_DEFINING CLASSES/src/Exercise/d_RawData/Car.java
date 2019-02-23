package Exercise.d_RawData;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engines;
    private Cargo cargos;
    private List<Tire> tires;

    public Car(String model, Engine engines, Cargo cargos, List<Tire> tires) {
        this.model = model;
        this.engines = engines;
        this.cargos = cargos;
        this.tires = tires;
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngines() {
        return this.engines;
    }

    public Cargo getCargos() {
        return this.cargos;
    }

    public List<Tire> getTires() {
        return this.tires;
    }

    public boolean checkTiresP() {
        for (Tire t : this.tires) {
            if (t.getTirePressure() < 1) {
                return true;
            }
        }

        return false;
    }
}
