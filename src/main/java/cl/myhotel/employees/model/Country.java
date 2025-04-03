package cl.myhotel.employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The region entity.
 *
 * @author Leonel Zeballos
 */
@Entity
@Table(name = "countries")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    /**
     * The country ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", length = 2, nullable = false)
    private String countryId;

    /**
     * The country name.
     */
    @Column(name = "country_name", length = 40, nullable = false)
    private String countryName;

    /**
     * The region
     */
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
