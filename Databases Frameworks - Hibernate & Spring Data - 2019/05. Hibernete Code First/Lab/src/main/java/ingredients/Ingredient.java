package ingredients;

import shampoos.BasicShampoo;

import java.math.BigDecimal;
import java.util.List;

public interface Ingredient {
    String getName();

    void setName(String name);

    int getId();

    int setId(int id);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    List<BasicShampoo> getShampoos();

    void setShampoos(List<BasicShampoo> shampoos);


}
