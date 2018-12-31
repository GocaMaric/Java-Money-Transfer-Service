package com.moneytransfer.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "moeny")
public class MoneyTransfer implements Serializable {

  private static final long serialVersionUID = -295422703255886286L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private Double amount;
  
  private String currency;
  
  private Date createdDate = new Date();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public String toString() {
    return "MoneyTransfer [id=" + id + ", amount=" + amount + ", currency=" + currency
        + ", createdDate=" + createdDate + "]";
  }
  
}
