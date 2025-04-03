package cl.myhotel.employees.repository;

import cl.myhotel.employees.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Job entity.
 *
 * @author Leonel Zeballos
 */
public interface JobRepository extends JpaRepository<Job, Long> {
}
