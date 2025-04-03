package cl.myhotel.employees.resource;

import cl.myhotel.employees.dto.EmployeeSegmentByDepartmentProjection;
import cl.myhotel.employees.dto.EmployeeSegmentProjection;
import cl.myhotel.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for managing employees.
 *
 * @author Leonel Zeballos
 */
@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeResource {

    /**
     * Service class for managing employees.
     */
    private final EmployeeService employeeService;

    @GetMapping("/segments")
    public ResponseEntity<EmployeeSegmentProjection> getEmployeeSegmentsCount() {
        return ResponseEntity.ok(employeeService.getEmployeeSegmentsCount());
    }

    @GetMapping("/segments/department")
    public ResponseEntity<List<EmployeeSegmentByDepartmentProjection>> getEmployeeSegmentsCountByDepartment() {
        return ResponseEntity.ok(employeeService.getEmployeeSegmentsCountByDepartment());
    }

}
