package cl.myhotel.employees.dto;

@SuppressWarnings("unused")
public interface EmployeeHighestSalaryProjection {
    String getDepartmentName();

    Long getEmployeeId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPhoneNumber();

    String getHireDate();

    String getJobId();

    Double getSalary();

    Double getCommissionPct();

    Long getManagerId();

    Long getDepartmentId();
}
