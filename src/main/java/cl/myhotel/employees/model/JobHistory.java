package cl.myhotel.employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The job history entity.
 *
 * @author Leonel Zeballos
 */
@Entity
@Table(name = "job_history")
@IdClass(JobHistoryId.class)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobHistory {

    /**
     * The employee ID.
     */
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false, length = 6)
    private BigDecimal employeeId;

    /**
     * The start date of the job.
     */
    @Id
    @Column(name = "START_DATE")
    private LocalDate startDate;

    /**
     * The end date of the job.
     */
    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    /**
     * The job reference.
     */
    @ManyToOne
    @JoinColumn(name = "JOB_ID", nullable = false)
    private Job job;

    /**
     * The department reference.
     */
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    /**
     * The employee reference (read-only as employee_id is part of PK)
     */
    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID", insertable = false, updatable = false)
    private Employee employee;
}