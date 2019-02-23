package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.enums.AgeRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByCopiesLessThan(Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal less, BigDecimal greater);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    //WthQuery
    @Query(
                    "select b " +
                    "from bookshopsystemapp.domain.entities.Book as b " +
                    "where b.title " +
                    "like :wildCard"
    )
    List<Book> findAllByTitleContains(@Param("wildCard") String wildCard);

    @Query(
            "SELECT b " +
                    "from bookshopsystemapp.domain.entities.Book as b " +
                    "join a.author as a " +
                    "where a.last_name " +
                    "like :p"
    )
    List<Book> findAllByTitleWhereAuthorStartWith(@Param("p") String letters);
}
