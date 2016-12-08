/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyConverter.view;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author daseel
 */
@Named(value = "converterView")
@SessionScoped
public class ConverterView implements Serializable{

    
    
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
    
    
    
}
