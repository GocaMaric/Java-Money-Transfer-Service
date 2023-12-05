package com.moneytransfer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "money")
public class MoneyTransfer implements Serializable {

    private static final long serialVersionUID = -295422703255886286L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal amount;

    private String currency;

    private final Date createdDate = new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getCreatedDate() {
        return new Date(createdDate.getTime()); // Returning a copy to maintain immutability
    }

    @Override
    public String toString() {
        return "MoneyTransfer [id=" + id + ", amount=" + amount + ", currency=" + currency
                + ", createdDate=" + createdDate + "]";
    }
}

}
