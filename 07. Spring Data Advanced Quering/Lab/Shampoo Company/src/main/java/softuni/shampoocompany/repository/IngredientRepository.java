package softuni.shampoocompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.shampoocompany.domain.entities.Ingredient;

import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String letters);

    List<Ingredient> findAllByNameInOrderByPrice(List<String> name);

    Set<Ingredient> findAllByNameIn(List<String> names);
}
