package cl.myhotel.employees.repository;

import cl.myhotel.employees.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Country entity.
 *
 * @author Leonel Zeballos
 */
@SuppressWarnings("unused")
public interface CountryRepository extends JpaRepository<Country, Long> {
}
