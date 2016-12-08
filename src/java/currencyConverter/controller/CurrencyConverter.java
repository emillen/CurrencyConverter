package currencyConverter.controller;

import currencyConverter.model.ConversionRate;
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

    private String to;
    private String from;
    private float amount;
    private String result;

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public float getAmount() {
        return amount;
    }

    public String getResult() {
        return result;
    }

    public void convert() {
        ConversionRate toRate = em.createNamedQuery("ConversionRate.findByName", ConversionRate.class)
                .setParameter("name", this.to).getSingleResult();
        ConversionRate fromRate = em.createNamedQuery("ConversionRate.findByName", ConversionRate.class)
                .setParameter("name", this.from).getSingleResult();

        float ratio = fromRate.getRate() / toRate.getRate();

        result = amount + " " + fromRate.getName() + " is" + amount * ratio + " " + toRate.getClass();
    }
}
