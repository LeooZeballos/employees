package cl.myhotel.employees.dto;

@SuppressWarnings("unused")
public interface AverageSalaryByDepartmentProjection {
    String getDepartmentName();

    Double getSalarioPromedio();
}
