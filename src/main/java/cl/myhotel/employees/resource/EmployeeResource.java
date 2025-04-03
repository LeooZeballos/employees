package cl.myhotel.employees.resource;

import cl.myhotel.employees.dto.*;
import cl.myhotel.employees.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/highest-salary")
    public ResponseEntity<List<EmployeeHighestSalaryDTO>> getEmployeeHighestSalaryByDepartment() {
        return ResponseEntity.ok(employeeService.getEmployeeHighestSalaryByDepartment());
    }

    @GetMapping("/managers")
    public ResponseEntity<List<EmployeeDTO>> getManagersHiredMoreThan15YearsAgo(
            @RequestParam(name = "years", defaultValue = "15") Integer years
    ) {
        return ResponseEntity.ok(employeeService.getManagersHiredMoreThan15YearsAgo(years));
    }

    @GetMapping("/average-salary")
    public ResponseEntity<List<AverageSalaryByDepartmentProjection>> getEmployeesWithSalaryAboveDepartmentAverage() {
        return ResponseEntity.ok(employeeService.getEmployeesWithSalaryAboveDepartmentAverage());
    }

    @GetMapping("/by-country")
    public ResponseEntity<List<EmployeesByCountryInformationProjection>> getEmployeesByCountryInformation() {
        return ResponseEntity.ok(employeeService.getEmployeesByCountryInformation());
    }

}
