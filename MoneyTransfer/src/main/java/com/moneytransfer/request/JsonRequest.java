package com.moneytransfer.request;

import java.math.BigDecimal;

public class JsonRequest {

    private BigDecimal amount;
    private String currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Add validation methods as needed

    public boolean isValid() {
        return amount != null && amount.compareTo(BigDecimal.ZERO) >= 0 && currency != null && !currency.isEmpty();
    }
}
