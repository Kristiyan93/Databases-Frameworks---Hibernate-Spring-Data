package softuni.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.demo.domain.entities.Ingredient;

import java.util.List;
import java.util.Set;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    Set<Ingredient> findAllByNameIn(List<String> ingreadientNames);

}
