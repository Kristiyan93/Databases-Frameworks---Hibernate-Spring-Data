package Exercise.d_BorderControl;

public class Robot extends Border {
    private String model;

    public Robot(String model, String id) {
        super(id);
        this.model = model;
    }

    public String getModel() {
        return this.model;
    }

    private void setModel(String model) {
        this.model = model;
    }
}
