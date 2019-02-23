package softuni.shampoocompany.service;

import org.springframework.stereotype.Service;
import softuni.shampoocompany.domain.entities.Ingredient;
import softuni.shampoocompany.repository.IngredientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<String> selectIngredientsByName(String letters) {
        List<Ingredient> ingredients = this.ingredientRepository.findByNameStartingWith(letters);

        return ingredients
                .stream()
                .map(s -> String.format(s.getName())).collect(Collectors.toList());
    }

    @Override
    public List<String> selectIngredientsByNames(List<String> names) {
        List<Ingredient> ingredients = this.ingredientRepository
                .findAllByNameInOrderByPrice(names);

        return ingredients
                .stream()
                .map(s -> String.format(s.getName()))
                .collect(Collectors.toList());
    }
}
