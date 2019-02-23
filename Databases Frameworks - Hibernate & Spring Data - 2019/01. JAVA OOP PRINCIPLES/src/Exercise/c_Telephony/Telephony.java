package Exercise.c_Telephony;

import java.util.ArrayList;
import java.util.List;

public class Telephony {
    private List<Smartphone> smartphones;
    private List<Browse> brouses;

    public Telephony() {
        this.smartphones = new ArrayList<>();
        this.brouses = new ArrayList<>();
    }

    public List<Smartphone> getSmartphones() {
        return this.smartphones;
    }

    public List<Browse> getBrowses() {
        return this.brouses;
    }
}
