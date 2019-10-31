package com.sukhijaa.udemy.currencyconversionservice;

import com.sukhijaa.udemy.currencyconversionservice.controller.CurrencyConvertionOutput;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface CurrencyExchangeProxy {

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyConvertionOutput getExchangeValue(@PathVariable String from, @PathVariable String to);

  @GetMapping("/currency-exchange")
  public List<CurrencyConvertionOutput> getAllExchangeVals();

}
