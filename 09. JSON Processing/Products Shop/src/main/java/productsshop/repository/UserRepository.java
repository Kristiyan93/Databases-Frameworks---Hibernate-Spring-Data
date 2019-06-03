package productsshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productsshop.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
