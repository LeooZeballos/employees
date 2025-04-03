package cl.myhotel.employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * The job entity.
 *
 * @author Leonel Zeballos
 */
@Entity
@Table(name = "jobs")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    /**
     * The job ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", length = 10, nullable = false)
    private String jobId;

    /**
     * The job title.
     */
    @Column(name = "job_title", length = 35, nullable = false)
    private String jobTitle;

    /**
     * The minimum salary.
     */
    @Column(name = "min_salary", precision = 6)
    private BigDecimal minSalary;

    /**
     * The maximum salary.
     */
    @Column(name = "max_salary", precision = 6)
    private BigDecimal maxSalary;

}
