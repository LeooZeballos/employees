package cl.myhotel.employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    /**
     * The employee ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", precision = 6)
    private BigDecimal employeeId;

    /**
     * The first name of the employee.
     */
    @Column(name = "first_name", length = 20)
    private String firstName;

    /**
     * The last name of the employee.
     */
    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    /**
     * The employee's email.
     */
    @Column(name = "email", length = 25, nullable = false)
    private String email;

    /**
     * The employee's phone number.
     */
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    /**
     * The hire date of the employee.
     */
    @Column(name = "hire_date")
    private LocalDate hireDate;

    /**
     * The job ID of the employee.
     */
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    /**
     * The salary of the employee.
     */
    @Column(name = "salary", precision = 8, scale = 2)
    private BigDecimal salary;

    /**
     * The commission percentage of the employee.
     */
    @Column(name = "commission_pct", precision = 2, scale = 2)
    private BigDecimal commissionPct;

    /**
     * The manager of the employee.
     */
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    /**
     * The department of the employee.
     */
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
