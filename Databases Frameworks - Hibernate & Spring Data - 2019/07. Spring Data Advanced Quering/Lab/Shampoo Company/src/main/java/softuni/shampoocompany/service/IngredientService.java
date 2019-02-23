package softuni.shampoocompany.service;

import java.util.List;

public interface IngredientService {

    List<String> selectIngredientsByName(String letters);

    List<String> selectIngredientsByNames(List<String> names);

}
