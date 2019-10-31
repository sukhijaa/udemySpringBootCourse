package com.sukhijaa.udemy.currencyconversionservice.controller;

import java.math.BigDecimal;

public class CurrencyConvertionOutput {


  private int id;
  private String from;
  private String to;
  private BigDecimal conversionFactor;
  private BigDecimal value;
  private BigDecimal convertedValue;
  private int port;

  public int getPort() {
    return port;
  }

  public CurrencyConvertionOutput() {
  }

  public CurrencyConvertionOutput(int id, String from, String to,
      BigDecimal conversionFactor, BigDecimal value, int port) {
    this.id = id;
    this.from = from;
    this.to = to;
    this.conversionFactor = conversionFactor;
    this.value = value;
    this.port = port;
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
