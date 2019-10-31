package com.sukhijaa.udemy.currencyconversionservice.controller;

import java.math.BigDecimal;

public class CurrencyConvertionOutput {


  private int id;
  private String from;
  private String to;
  private BigDecimal conversionFactor;
  private BigDecimal value;
  private BigDecimal convertedValue;


  public CurrencyConvertionOutput() {
  }

  public CurrencyConvertionOutput(int id, String from, String to,
      BigDecimal conversionFactor, BigDecimal value) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionFactor = conversionFactor;
    this.value = value;
  }

  public int getId() {
    return id;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public BigDecimal getConversionFactor() {
    return conversionFactor;
  }

  public BigDecimal getValue() {
    return value;
  }

  public BigDecimal getConvertedValue() {
    return conversionFactor.multiply(value);
  }
}
