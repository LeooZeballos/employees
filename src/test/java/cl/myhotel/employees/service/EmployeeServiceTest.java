package cl.myhotel.employees.service;

import cl.myhotel.employees.dto.*;
import cl.myhotel.employees.mapper.EmployeeMapper;
import cl.myhotel.employees.model.Employee;
import cl.myhotel.employees.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @BeforeEach
    public void setUp() {
        try (AutoCloseable ignored = openMocks(this)) {
            employeeService = new EmployeeService(employeeRepository, employeeMapper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testShouldGetEmployeeSegmentsCount() {
        // Given
        EmployeeSegmentProjection employeeSegmentProjection = mock(EmployeeSegmentProjection.class);
        when(employeeRepository.getEmployeeSegmentsCount()).thenReturn(employeeSegmentProjection);

        // When
        EmployeeSegmentProjection result = employeeService.getEmployeeSegmentsCount();

        // Then
        assertNotNull(result);
        assertEquals(employeeSegmentProjection, result);
    }

    @Test
    void testShouldGetEmployeeSegmentsCountByDepartment() {
        // Given
        List<EmployeeSegmentByDepartmentProjection> employeeSegmentProjections = new ArrayList<>();
        when(employeeRepository.getEmployeeSegmentsCountByDepartment()).thenReturn(employeeSegmentProjections);

        // When
        List<EmployeeSegmentByDepartmentProjection> result = employeeService.getEmployeeSegmentsCountByDepartment();

        // Then
        assertNotNull(result);
        assertEquals(employeeSegmentProjections, result);
    }

    @Test
    void testShouldGetEmployeeHighestSalaryByDepartment() {
        // Given
        List<EmployeeHighestSalaryProjection> employeeHighestSalaryProjections = new ArrayList<>();
        when(employeeRepository.getHighestSalaryByDepartment()).thenReturn(employeeHighestSalaryProjections);

        // When
        List<EmployeeHighestSalaryDTO> result = employeeService.getEmployeeHighestSalaryByDepartment();

        // Then
        assertNotNull(result);
        assertEquals(employeeHighestSalaryProjections.size(), result.size());
    }

    @Test
    void testShouldGetManagersHiredMoreThan15YearsAgo() {
        // Given
        Integer years = 15;
        List<Employee> employees = new ArrayList<>();
        when(employeeRepository.getManagersHiredMoreThan15YearsAgo(years)).thenReturn(employees);

        // When
        List<EmployeeDTO> result = employeeService.getManagersHiredMoreThan15YearsAgo(years);

        // Then
        assertNotNull(result);
        assertEquals(employees.size(), result.size());
    }

    @Test
    void testShouldGetEmployeesWithSalaryAboveDepartmentAverage() {
        // Given
        Integer having = 10;
        List<AverageSalaryByDepartmentProjection> employees = new ArrayList<>();

        when(employeeRepository.getAverageSalaryByDepartmentWithMoreThan10Employees(having)).thenReturn(employees);

        // When
        List<AverageSalaryByDepartmentProjection> result = employeeService.getEmployeesWithSalaryAboveDepartmentAverage(having);

        // Then
        assertNotNull(result);
        assertEquals(employees, result);
    }

    @Test
    void testShouldGetEmployeesByCountryInformation() {
        // Given
        List<EmployeesByCountryInformationProjection> employees = new ArrayList<>();
        when(employeeRepository.getEmployeeSegmentsCountByCountry()).thenReturn(employees);

        // When
        List<EmployeesByCountryInformationProjection> result = employeeService.getEmployeesByCountryInformation();

        // Then
        assertNotNull(result);
        assertEquals(employees, result);
    }
}