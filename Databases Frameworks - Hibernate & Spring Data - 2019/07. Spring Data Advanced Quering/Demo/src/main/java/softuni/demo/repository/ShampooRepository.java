package softuni.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.demo.domain.entities.Ingredient;
import softuni.demo.domain.entities.Shampoo;
import softuni.demo.domain.entities.Size;

import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    @Query("SELECT s FROM softuni.demo.domain.entities.Shampoo AS s JOIN s.ingredients AS i WHERE i IN :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") Set<Ingredient> ingredients);
}
