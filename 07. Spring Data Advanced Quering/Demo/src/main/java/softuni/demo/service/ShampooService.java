package softuni.demo.service;

import java.util.List;

public interface ShampooService {

    List<String> selectShampooBySize(String inputSize);

    List<String> selectShampoosByIngredients(List<String> ingredientNames);
}
