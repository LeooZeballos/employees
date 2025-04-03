package cl.myhotel.employees.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

@SuppressWarnings("unused")
public interface EmployeeHighestSalaryProjection {
    String getDepartmentName();

    BigDecimal getEmployeeId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhoneNumber();

    LocalDate getHireDate();

    String getJobId();

    BigDecimal getSalary();

    BigDecimal getCommissionPct();

    Long getManagerId();

    Long getDepartmentId();
}
