package cl.myhotel.employees.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * The location entity.
 *
 * @author Leonel Zeballos
 */
@Entity
@Table(name = "locations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Location {

    // LOCATION_ID    decimal(4) default 0 not null
    //        primary key,
    /**
     * The location ID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", precision = 6)
    private BigDecimal locationId;

    /**
     * The street address.
     */
    @Column(name = "street_address", length = 40)
    private String streetAddress;

    /**
     * The postal code.
     */
    @Column(name = "postal_code", length = 12)
    private String postalCode;

    /**
     * The city.
     */
    @Column(name = "city", length = 30)
    private String city;

    /**
     * The state province.
     */
    @Column(name = "state_province", length = 25)
    private String stateProvince;

    /**
     * The country.
     */
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

}
