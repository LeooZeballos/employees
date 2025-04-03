package cl.myhotel.employees.dto;

@SuppressWarnings("unused")
public interface EmployeeSegmentByDepartmentProjection {
    String getDepartmentName();

    Long getSegmentA();

    Long getSegmentB();

    Long getSegmentC();
}
