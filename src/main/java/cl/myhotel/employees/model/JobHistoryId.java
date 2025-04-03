package cl.myhotel.employees.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The job history ID class.
 *
 * @author Leonel Zeballos
 */
@AllArgsConstructor
@EqualsAndHashCode
public class JobHistoryId implements Serializable {
    /**
     * The employee ID.
     */
    private BigDecimal employeeId;
    /**
     * The start date of the job.
     */
    private LocalDate startDate;
}
