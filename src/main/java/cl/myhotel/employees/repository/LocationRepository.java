package cl.myhotel.employees.repository;

import cl.myhotel.employees.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Location entity.
 *
 * @author Leonel Zeballos
 */
public interface LocationRepository extends JpaRepository<Location, Long> {
}
