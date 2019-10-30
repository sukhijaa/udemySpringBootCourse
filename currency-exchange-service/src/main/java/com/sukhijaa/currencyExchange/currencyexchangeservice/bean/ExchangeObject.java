package com.sukhijaa.currencyExchange.currencyexchangeservice.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExchangeObject {

  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "exchange_from")
  private String from;

  @Column(name = "exchange_to")
  private String to;

  private float conversionFactor;
  private int port;

  public ExchangeObject() {
  }

  public ExchangeObject(Long id, String from, String to, float conversionFactor) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionFactor = conversionFactor;
  }

  public Long getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public float getConversionFactor() {
    return conversionFactor;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
