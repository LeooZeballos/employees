package cl.myhotel.employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "departments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    /**
     * The department ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", precision = 4)
    private BigDecimal departmentId;

    /**
     * The department name.
     */
    @Column(name = "department_name", length = 30, nullable = false)
    private String departmentName;

    /**
     * The manager ID.
     */
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    /**
     * The location ID.
     */
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
