package shampoos;

import enums.Size;
import labels.BasicLabel;

import java.math.BigDecimal;

public class FreshNuke extends BasicShampoo {
    private static final String BRAND = "Fresh Nuke";
    private static final BigDecimal PRICE = new BigDecimal("9.33");
    private static final Size SIZE = Size.LARGE;

    public FreshNuke() { }

    public FreshNuke(BasicLabel label) {
        super(BRAND, PRICE, SIZE, label);
    }
}
