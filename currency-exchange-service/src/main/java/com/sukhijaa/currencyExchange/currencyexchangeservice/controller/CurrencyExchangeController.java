package com.sukhijaa.currencyExchange.currencyexchangeservice.controller;

import com.sukhijaa.currencyExchange.currencyexchangeservice.bean.ExchangeObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

  @Autowired
  private Environment environment;

  @Autowired
  private ExchangeObjectService exchangeObjectService;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public ExchangeObject getExchangeValue(@PathVariable String from, @PathVariable String to) {
    ExchangeObject exchangeObject = exchangeObjectService.findByFromAndTo(from, to);
    exchangeObject.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
    return exchangeObject;
  }

  @GetMapping("/currency-exchange")
  public List<ExchangeObject> getAllExchangeVals() {
    return exchangeObjectService.findAll();
  }
}
