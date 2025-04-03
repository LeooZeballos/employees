package cl.myhotel.employees.dto;

@SuppressWarnings("unused")
public interface EmployeesByCountryInformationProjection {
    String getCountryName();

    String getCantidadEmpleados();

    Double getSalarioPromedio();

    Double getSalarioMaximo();

    Double getSalarioMinimo();

    Double getPromedioAntiguedadAnios();
}
