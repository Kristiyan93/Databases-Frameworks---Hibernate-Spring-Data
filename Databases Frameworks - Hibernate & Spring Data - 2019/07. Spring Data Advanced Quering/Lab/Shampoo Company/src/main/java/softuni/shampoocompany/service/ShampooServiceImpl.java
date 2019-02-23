package softuni.shampoocompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.shampoocompany.domain.entities.Ingredient;
import softuni.shampoocompany.domain.entities.Label;
import softuni.shampoocompany.domain.entities.Shampoo;
import softuni.shampoocompany.domain.entities.Size;
import softuni.shampoocompany.repository.IngredientRepository;
import softuni.shampoocompany.repository.ShampooRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShampooServiceImpl implements ShampooService {
    public final ShampooRepository shampooRepository;

    @Autowired
    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public List<String> selectShampoosBySize(String inputSize) {
        Size size = Size.valueOf(inputSize.toUpperCase());

        List<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrderById(size);

        return shampoos
                .stream()
                .map(s -> String.format("%s %s %.2f", s.getBrand(), s.getSize(), s.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectShampoosBySizeOrLabel(String inputSize, Long inputId) {
        Size size = Size.valueOf(inputSize.toUpperCase());
        Label label = new Label();
        label.setId(inputId);

        List<Shampoo> shampoos = this.shampooRepository.findAllBySizeOrLabelOrderByPrice(size, label);

        return shampoos
                .stream()
                .map(s -> String.format("%s %s %.2f", s.getBrand(), s.getSize(), s.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> selectShampoosByPrice(BigDecimal inputPrice) {
        Ingredient ingredient = new Ingredient();
        ingredient.setPrice(inputPrice);

        List<Shampoo> shampoos = this.shampooRepository.findAllByPriceGreaterThanEqualOrderByPriceDesc(inputPrice);

        return shampoos
                .stream()
                .map(s -> String.format("%s %s %.2f", s.getBrand(), s.getSize(), s.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer countShampoosByPrice(BigDecimal inputPrice) {
        List<Shampoo> shampoos = this.shampooRepository.findAllByPriceLessThan(inputPrice);

        return shampoos.size();
    }

    @Override
    public List<String> selectShampoosByIngredients(List<String> ingredientNames) {
        IngredientRepository ingredientRepository = null;

        Set<Ingredient> ingredients = ingredientRepository.findAllByNameIn(ingredientNames);

        List<Shampoo> shampoos = this.shampooRepository.findByIngredientsIn(ingredients);

        return shampoos
                .stream()
                .map(s -> String.format(s.getBrand()))
                .collect(Collectors.toList());
    }
}
