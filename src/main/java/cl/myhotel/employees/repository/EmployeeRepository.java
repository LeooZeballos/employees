package cl.myhotel.employees.repository;

import cl.myhotel.employees.dto.EmployeeSegmentByDepartmentProjection;
import cl.myhotel.employees.dto.EmployeeSegmentProjection;
import cl.myhotel.employees.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for Employee entity.
 *
 * @author Leonel Zeballos
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /*
    -- i. Obtener cantidad de empleados dentro de los siguientes segmentos de sueldo:
    -- SEGMENTO A: menor a USD 3.500
    -- SEGMENTO B: mayor o igual a USD 3.500 y menor que USD 8.000
    -- SEGMENTO C: mayor o igual a USD 8.000.
    SELECT SUM(IF(salary < 3500, 1, 0))                    AS "SEGMENTO A",
           SUM(IF(salary >= 3500 AND salary < 8000, 1, 0)) AS "SEGMENTO B",
           SUM(IF(salary >= 8000, 1, 0))                   AS "SEGMENTO C"
    FROM employees;
    */
    @SuppressWarnings("SqlResolve")
    @Query(value = """
            SELECT SUM(IF(salary < 3500, 1, 0))                    AS segment_a,
                   SUM(IF(salary >= 3500 AND salary < 8000, 1, 0)) AS segment_b,
                   SUM(IF(salary >= 8000, 1, 0))                   AS segment_c
            FROM employees
            """, nativeQuery = true)
    EmployeeSegmentProjection getEmployeeSegmentsCount();

    /*
    -- ii. Utilizando la tabla “departments” se requiere realizar la misma agrupación de segmentos de sueldo,
    -- pero por departamento.
    SELECT d.department_name,
           SUM(IF(e.salary < 3500, 1, 0))                      AS "SEGMENTO A",
           SUM(IF(e.salary >= 3500 AND e.salary < 8000, 1, 0)) AS "SEGMENTO B",
           SUM(IF(e.salary >= 8000, 1, 0))                     AS "SEGMENTO C"
    FROM employees e
             LEFT JOIN departments d ON e.department_id = d.department_id
    GROUP BY d.department_name
    ORDER BY d.department_name;
    */
    @SuppressWarnings("SqlResolve")
    @Query(value = """
            SELECT COALESCE(d.department_name, 'Sin departamento')      AS department_name,
                   SUM(IF(e.salary < 3500, 1, 0))                       AS segment_a,
                   SUM(IF(e.salary >= 3500 AND e.salary < 8000, 1, 0))  AS segment_b,
                   SUM(IF(e.salary >= 8000, 1, 0))                      AS segment_c
            FROM employees e
                     LEFT JOIN departments d ON e.department_id = d.department_id
            GROUP BY d.department_name
            ORDER BY d.department_name
            """, nativeQuery = true)
    List<EmployeeSegmentByDepartmentProjection> getEmployeeSegmentsCountByDepartment();

    /*
    -- iii. Información del empleado con mayor sueldo de cada departamento.
    SELECT d.department_name,
           e.*
    FROM employees e
             LEFT JOIN departments d ON e.department_id = d.department_id
    WHERE (d.department_name, e.salary) IN (SELECT d.department_name,
                                                   MAX(e.salary)
                                            FROM employees e
                                                     LEFT JOIN departments d ON e.department_id = d.department_id
                                            GROUP BY d.department_name)
    ORDER BY d.department_name;

    -- iv. Información de los gerentes que hayan sido contratados hace más de 15 años.
    SELECT e.*
    FROM employees e
             LEFT JOIN employees m ON e.manager_id = m.employee_id
    WHERE m.manager_id IS NOT NULL
      AND e.hire_date < DATE_SUB(CURDATE(), INTERVAL 15 YEAR)
    ORDER BY e.hire_date;

    -- v. Salario promedio de todos los departamentos que tengan más de 10 empleados.
    SELECT d.department_name,
           ROUND(AVG(e.salary), 2) AS "salario_promedio"
    FROM employees e
             LEFT JOIN departments d ON e.department_id = d.department_id
    WHERE d.department_id IN (SELECT department_id
                                FROM employees
                                GROUP BY department_id
                                HAVING COUNT(employee_id) > 10)
    GROUP BY d.department_name
    ORDER BY d.department_name;


    -- vi. Obtener la siguiente información agrupada por país: cantidad empleados, salario promedio, salario más alto,
    -- salario más bajo, promedio años antigüedad
    SELECT
        c.country_name,
        COUNT(e.employee_id) AS "cantidad_empleados",
        ROUND(AVG(e.salary), 2) AS "salario_promedio",
        MAX(e.salary) AS "salario_maximo",
        MIN(e.salary) AS "salario_minimo",
        ROUND(AVG(DATEDIFF(CURDATE(), e.hire_date)/365), 2) AS "promedio_antiguedad_anios"
    FROM
        employees e
            LEFT JOIN departments d ON e.department_id = d.department_id
            LEFT JOIN locations l ON d.location_id = l.location_id
            LEFT JOIN countries c ON l.country_id = c.country_id
    GROUP BY
        c.country_name
    ORDER BY
        c.country_name;
    */

}
