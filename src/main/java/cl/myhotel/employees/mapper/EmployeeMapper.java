package cl.myhotel.employees.mapper;

import cl.myhotel.employees.dto.EmployeeDTO;
import cl.myhotel.employees.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for converting between Employee and EmployeeDTO.
 *
 * @author Leonel Zeballos
 */
@Component
public class EmployeeMapper {

    /**
     * Converts an Employee entity to an EmployeeDTO.
     *
     * @param employee the Employee entity
     * @return the EmployeeDTO
     */
    public EmployeeDTO toDTO(Employee employee) {
        if (employee == null) {
            return null;
        }

        return EmployeeDTO.builder()
                .employeeId(employee.getEmployeeId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phoneNumber(employee.getPhoneNumber())
                .hireDate(employee.getHireDate())
                .salary(employee.getSalary())
                .commissionPct(employee.getCommissionPct())
                .jobTitle(employee.getJob() != null ? employee.getJob().getJobTitle() : null)
                .departmentName(employee.getDepartment() != null ? employee.getDepartment().getDepartmentName() : null)
                .managerName(employee.getManager() != null ? employee.getManager().getFirstName() + " " + employee.getManager().getLastName() : null)
                .build();
    }

    /**
     * Converts an EmployeeDTO to an Employee entity.
     *
     * @param employeeDTO the EmployeeDTO
     * @return the Employee entity
     */
    public Employee toEntity(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setHireDate(employeeDTO.getHireDate());
        employee.setSalary(employeeDTO.getSalary());
        employee.setCommissionPct(employeeDTO.getCommissionPct());
        // job, department, and manager should be set separately as they are entities
        return employee;
    }

    /**
     * Converts a list of Employee entities to a list of EmployeeDTOs.
     *
     * @param employees the list of Employee entities
     * @return the list of EmployeeDTOs
     */
    public List<EmployeeDTO> toDTO(List<Employee> employees) {
        if (employees == null) {
            return null;
        }

        return employees.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    /**
     * Converts a list of EmployeeDTOs to a list of Employee entities.
     *
     * @param employeeDTOs the list of EmployeeDTOs
     * @return the list of Employee entities
     */
    @SuppressWarnings("unused")
    public List<Employee> toEntity(List<EmployeeDTO> employeeDTOs) {
        if (employeeDTOs == null) {
            return null;
        }

        return employeeDTOs.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

}