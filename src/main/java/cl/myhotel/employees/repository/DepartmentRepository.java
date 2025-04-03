package cl.myhotel.employees.repository;

import cl.myhotel.employees.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Department entity.
 *
 * @author Leonel Zeballos
 */
@SuppressWarnings("unused")
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
