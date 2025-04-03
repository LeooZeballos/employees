package cl.myhotel.employees.repository;

import cl.myhotel.employees.model.JobHistory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for JobHistory entity.
 *
 * @author Leonel Zeballos
 */
@SuppressWarnings("unused")
public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {
}
