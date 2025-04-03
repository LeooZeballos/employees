package cl.myhotel.employees.service;

import cl.myhotel.employees.dto.EmployeeSegmentByDepartmentProjection;
import cl.myhotel.employees.dto.EmployeeSegmentProjection;
import cl.myhotel.employees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing employees.
 *
 * @author Leonel Zeballos
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeSegmentProjection getEmployeeSegmentsCount() {
        return employeeRepository.getEmployeeSegmentsCount();
    }

    public List<EmployeeSegmentByDepartmentProjection> getEmployeeSegmentsCountByDepartment() {
        return employeeRepository.getEmployeeSegmentsCountByDepartment();
    }

}
