package com.sukhijaa.currencyExchange.currencyexchangeservice.bean;

public class ExchangeObject {

  private Long id;
  private String from;
  private String to;
  private float conversionFactor;

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
}
