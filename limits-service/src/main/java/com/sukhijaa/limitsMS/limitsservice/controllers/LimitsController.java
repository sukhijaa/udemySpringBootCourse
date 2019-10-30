package com.sukhijaa.limitsMS.limitsservice.controllers;

import com.sukhijaa.limitsMS.limitsservice.beans.LimitValues;
import com.sukhijaa.limitsMS.limitsservice.configs.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

  @Autowired
  private Configuration configuration;

  @GetMapping("/limits")
  public LimitValues getLimits() {
    return new LimitValues(configuration.getMinimum(), configuration.getMaximum());
  }
}
