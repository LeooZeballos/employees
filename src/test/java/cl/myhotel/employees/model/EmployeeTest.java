package cl.myhotel.employees.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeTest {

    private Employee employee;
    private Employee manager;
    private Department department;
    private Job job;

    @BeforeEach
    void setUp() {
        // Create mock dependencies
        manager = Mockito.mock(Employee.class);
        department = Mockito.mock(Department.class);
        job = Mockito.mock(Job.class);

        // Set up mock behavior
        when(manager.getEmployeeId()).thenReturn(BigDecimal.valueOf(100));
        when(department.getDepartmentId()).thenReturn(new BigDecimal(1));
        when(department.getDepartmentName()).thenReturn("IT");
        when(department.getManager()).thenReturn(manager);
        when(department.getLocation()).thenReturn(null); // Assuming location is not needed for this test
        when(job.getJobTitle()).thenReturn("Programmer");
        when(job.getJobId()).thenReturn("IT_PROG");

        // Create test employee using builder pattern
        employee = Employee.builder()
                .employeeId(BigDecimal.valueOf(101))
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@myhotel.cl")
                .phoneNumber("+56912345678")
                .hireDate(LocalDate.of(2020, 1, 15))
                .job(job)
                .salary(new BigDecimal("5000.00"))
                .commissionPct(new BigDecimal("0.10"))
                .manager(manager)
                .department(department)
                .build();
    }

    @Test
    void testEmployeeCreation() {
        assertNotNull(employee);
        assertEquals(BigDecimal.valueOf(101), employee.getEmployeeId());
        assertEquals("John", employee.getFirstName());
        assertEquals("Doe", employee.getLastName());
        assertEquals("john.doe@myhotel.cl", employee.getEmail());
        assertEquals("+56912345678", employee.getPhoneNumber());
        assertEquals(LocalDate.of(2020, 1, 15), employee.getHireDate());
        assertEquals(new BigDecimal("5000.00"), employee.getSalary());
        assertEquals(new BigDecimal("0.10"), employee.getCommissionPct());
    }

    @Test
    void testRelationships() {
        assertNotNull(employee.getJob());
        assertEquals("IT_PROG", employee.getJob().getJobId());

        assertNotNull(employee.getManager());
        assertEquals(BigDecimal.valueOf(100), employee.getManager().getEmployeeId());

        assertNotNull(employee.getDepartment());
        assertEquals(new BigDecimal(1), employee.getDepartment().getDepartmentId());
    }

    @Test
    void testEqualsAndHashCode() {
        Employee sameEmployee = Employee.builder()
                .employeeId(BigDecimal.valueOf(101))
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@myhotel.cl")
                .phoneNumber("+56912345678")
                .hireDate(LocalDate.of(2020, 1, 15))
                .job(job)
                .salary(new BigDecimal("5000.00"))
                .commissionPct(new BigDecimal("0.10"))
                .manager(manager)
                .department(department)
                .build();

        Employee differentEmployee = Employee.builder()
                .employeeId(BigDecimal.valueOf(102))
                .firstName("Jane")
                .lastName("Smith")
                .email("jane.smith@myhotel.cl")
                .build();

        assertEquals(employee, sameEmployee);
        assertEquals(employee.hashCode(), sameEmployee.hashCode());
        assertNotEquals(employee, differentEmployee);
    }

    @Test
    void testToString() {
        String toString = employee.toString();
        assertTrue(toString.contains("John"));
        assertTrue(toString.contains("Doe"));
        assertTrue(toString.contains("101"));
    }

    @Test
    void testNoArgsConstructor() {
        Employee emptyEmployee = new Employee();
        assertNull(emptyEmployee.getEmployeeId());
        assertNull(emptyEmployee.getFirstName());
        assertNull(emptyEmployee.getLastName());
        assertNull(emptyEmployee.getEmail());
    }

    @Test
    void testAllArgsConstructor() {
        Employee customEmployee = new Employee(
                BigDecimal.valueOf(103),
                "Alice",
                "Johnson",
                "alice.johnson@myhotel.cl",
                "+56987654321",
                LocalDate.of(2021, 5, 20),
                job,
                new BigDecimal("6000.00"),
                new BigDecimal("0.15"),
                manager,
                department
        );

        assertEquals(BigDecimal.valueOf(103), customEmployee.getEmployeeId());
        assertEquals("Alice", customEmployee.getFirstName());
        assertEquals("Johnson", customEmployee.getLastName());
        assertEquals(LocalDate.of(2021, 5, 20), customEmployee.getHireDate());
    }
}