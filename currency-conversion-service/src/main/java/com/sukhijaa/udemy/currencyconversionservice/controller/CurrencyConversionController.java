package com.sukhijaa.udemy.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

  @GetMapping("/currency-convertion/from/{from}/to/{to}/value/{value}")
  public CurrencyConvertionOutput getConvertedValue(
      @PathVariable String from, @PathVariable String to,
      @PathVariable int value) {

    Map<String, String> pathVariables = new HashMap<>();
    pathVariables.put("from", from);
    pathVariables.put("to", to);
    ResponseEntity<CurrencyConvertionOutput> exchangeOutput = new RestTemplate().getForEntity(
        "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
        CurrencyConvertionOutput.class,
        pathVariables);
    CurrencyConvertionOutput exchangeObj = exchangeOutput.getBody();
    return new CurrencyConvertionOutput(
        exchangeObj.getId(),
        exchangeObj.getFrom(),
        exchangeObj.getTo(),
        exchangeObj.getConversionFactor(), BigDecimal.valueOf(value));
  }
}
