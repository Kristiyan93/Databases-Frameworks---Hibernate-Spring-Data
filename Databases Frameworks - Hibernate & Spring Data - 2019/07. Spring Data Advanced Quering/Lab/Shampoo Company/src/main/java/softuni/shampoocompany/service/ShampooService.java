package softuni.shampoocompany.service;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {

    List<String> selectShampoosBySize(String inputSize);

    List<String> selectShampoosBySizeOrLabel(String inputSize, Long inputId);

    List<String> selectShampoosByPrice(BigDecimal inputPrice);

    Integer countShampoosByPrice(BigDecimal inputPrice);

    List<String> selectShampoosByIngredients(List<String> ingredientNames);

}
