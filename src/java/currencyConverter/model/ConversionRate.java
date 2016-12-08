package currencyConverter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Represents a conversion rate
 * @author daseel, simonene
 */
@Entity
@Table(name = "CONVERSION_RATE")
@NamedQueries({
    @NamedQuery(
            name = "ConversionRate.findAll",
            query = "SELECT c FROM ConversionRate c"
    )
    , 
    @NamedQuery(
            name = "ConversionRate.findByName",
            query = "SELECT c FROM ConversionRate c WHERE c.name = :name")
        
})
public class ConversionRate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Float rate;

    public ConversionRate() {
    }

    
    /**
     * 
     * @return The name of the currency
     */
    public String getName() {
        return name;
    }
    
    /**
     * 
     * @return the conversion rate
     */
    public Float getRate() {
        return rate;
    }
}
