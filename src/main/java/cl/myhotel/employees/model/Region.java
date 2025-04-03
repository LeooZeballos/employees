package cl.myhotel.employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * The region entity.
 *
 * @author Leonel Zeballos
 */
@Entity
@Table(name = "regions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    /**
     * The region ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", length = 5, nullable = false)
    private BigInteger regionId;

    /**
     * The region name.
     */
    @Column(name = "region_name", length = 25, nullable = false)
    private String regionName;

}
