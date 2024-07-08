package small_market.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import small_market.entity.SnackOrder;

@Repository
public interface SnackOrderRepository extends JpaRepository<SnackOrder, Integer> {
}
