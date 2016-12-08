package currencyConverter.controller;

import currencyConverter.model.ConversionRate;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * This controller type class will be doing the currency converting
 *
 * @author daseel
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class CurrencyConverter {

    @PersistenceContext(unitName = "CurrencyConverterPU")
    private EntityManager em;

    public float convert(String from, String to, float amount) {
        
        ConversionRate toRate = em.createNamedQuery("ConversionRate.findByName", ConversionRate.class)
                .setParameter("name", to).getSingleResult();
        ConversionRate fromRate = em.createNamedQuery("ConversionRate.findByName", ConversionRate.class)
                .setParameter("name", from).getSingleResult();

        float ratio =   toRate.getRate() / fromRate.getRate();

        return amount * ratio;
    }

    public List<ConversionRate> allRates() {
        return em.createNamedQuery("ConversionRate.findAll", ConversionRate.class).getResultList();
    }
}
