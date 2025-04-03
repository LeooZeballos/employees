package cl.myhotel.employees.service;

import cl.myhotel.employees.dto.*;
import cl.myhotel.employees.mapper.EmployeeMapper;
import cl.myhotel.employees.model.Employee;
import cl.myhotel.employees.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service class for managing employees.
 *
 * @author Leonel Zeballos
 */
@Service
@RequiredArgsConstructor
public class EmployeeService {

    /**
     * Repository interface for Employee entity.
     */
    private final EmployeeRepository employeeRepository;

    /**
     * Mapper class for converting between Employee and EmployeeDTO.
     */
    private final EmployeeMapper employeeMapper;

    /**
     * i. Cantidad de empleados por segmento de sueldo.
     */
    public EmployeeSegmentProjection getEmployeeSegmentsCount() {
        return employeeRepository.getEmployeeSegmentsCount();
    }

    /**
     * ii. Cantidad de empleados por segmento de sueldo y por departamento.
     */
    public List<EmployeeSegmentByDepartmentProjection> getEmployeeSegmentsCountByDepartment() {
        return employeeRepository.getEmployeeSegmentsCountByDepartment();
    }

    /**
     * iii. Información del empleado con mayor sueldo de cada departamento.
     */
    public List<EmployeeHighestSalaryDTO> getEmployeeHighestSalaryByDepartment() {
        List<EmployeeHighestSalaryProjection> highestSalaryByDepartment = employeeRepository.getHighestSalaryByDepartment();

        List<EmployeeHighestSalaryDTO> highestSalaryDTOList = new ArrayList<>();
        for (EmployeeHighestSalaryProjection employeeHighestSalaryProjection : highestSalaryByDepartment) {
            EmployeeHighestSalaryDTO employeeHighestSalaryDTO = new EmployeeHighestSalaryDTO();
            employeeHighestSalaryDTO.setDepartmentName(employeeHighestSalaryProjection.getDepartmentName());
            employeeHighestSalaryDTO.setEmployee(employeeMapper.toDTO(employeeHighestSalaryProjection));
            highestSalaryDTOList.add(employeeHighestSalaryDTO);
        }

        return highestSalaryDTOList;
    }

    /**
     * iv. Información de los gerentes que hayan sido contratados hace más de 15 años.
     */
    public List<EmployeeDTO> getManagersHiredMoreThan15YearsAgo(Integer years) {
        List<Employee> managersHiredMoreThan15YearsAgo = employeeRepository.getManagersHiredMoreThan15YearsAgo(years);
        return employeeMapper.toDTO(managersHiredMoreThan15YearsAgo);
    }

    /**
     * v. Salario promedio de todos los departamentos que tengan más de 10 empleados.
     */
    public List<AverageSalaryByDepartmentProjection> getEmployeesWithSalaryAboveDepartmentAverage() {
        return employeeRepository.getAverageSalaryByDepartmentWithMoreThan10Employees();
    }

    /**
     * vi. Obtener la siguiente información agrupada por país: cantidad empleados, salario promedio, salario más alto,
     * salario más bajo, promedio años antigüedad
     */
    public List<EmployeesByCountryInformationProjection> getEmployeesByCountryInformation() {
        return employeeRepository.getEmployeeSegmentsCountByCountry();
    }

}
