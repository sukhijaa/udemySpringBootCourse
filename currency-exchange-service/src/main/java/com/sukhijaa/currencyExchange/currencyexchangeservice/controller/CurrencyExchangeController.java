package com.sukhijaa.currencyExchange.currencyexchangeservice.controller;

import com.sukhijaa.currencyExchange.currencyexchangeservice.bean.ExchangeObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeObject getExchangeValue(@PathVariable String from, @PathVariable String to) {
    return new ExchangeObject((long) 1, from, to, 65);
  }
}
