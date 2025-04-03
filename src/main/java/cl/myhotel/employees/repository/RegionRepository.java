package cl.myhotel.employees.repository;

import cl.myhotel.employees.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Region entity.
 *
 * @author Leonel Zeballos
 */
public interface RegionRepository extends JpaRepository<Region, Long> {
}
