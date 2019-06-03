package softuni.shampoocompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.shampoocompany.domain.entities.Ingredient;
import softuni.shampoocompany.domain.entities.Label;
import softuni.shampoocompany.domain.entities.Shampoo;
import softuni.shampoocompany.domain.entities.Size;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelOrderByPrice(Size size, Label id);

    List<Shampoo> findAllByPriceGreaterThanEqualOrderByPriceDesc(BigDecimal price);

    List<Shampoo> findAllByPriceLessThan(BigDecimal inputPrice);

    @Query("select s from softuni.shampoocompany.domain.entities.Shampoo as s" +
            " join s.ingredients as i where i in :ingredients")
    List<Shampoo> findByIngredientsIn(@Param(value = "ingredients") Set<Ingredient> ingredients);
}
