/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyConverter.view;

import currencyConverter.controller.CurrencyConverter;
import currencyConverter.model.ConversionRate;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author daseel
 */
@Named(value = "converterView")
@SessionScoped
public class ConverterView implements Serializable {

    @EJB
    CurrencyConverter cc;

    private String to;
    private String from;
    private float amount;
    private String result;

    /**
     * Creates a new instance of ConverterView
     */
    public ConverterView() {
    }

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

    public String convert() {

        if (to == null && from == null && amount == 0) {
            return "";
        }

        float converted = cc.convert(from, to, amount);
        result = amount + " " + from + " is " + converted + " " + to;

        return "";
    }
    
    public List<ConversionRate> getRates(){
    
        return cc.allRates();
    
    }
}
