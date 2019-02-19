package Exercise.d_BorderControl;

public abstract class Border {
    private String id;

    public Border(String id) {
        setId(id);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
