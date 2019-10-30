package com.sukhijaa.springrest.sukhijaaspringbootrest.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @Autowired
  private MessageSource messageSource;

  @GetMapping("/hw1")
  public String helloWorldHandler() {
    return "Hello World";
  }

  @RequestMapping(method = RequestMethod.GET, path = "/hw2")
  public String helloWorld2Handlers() {
    return "Hello World 2";
  }

  @GetMapping("/hwBean")
  public HelloWorldBean helloWorldBeanHandler() {
    return new HelloWorldBean("Hello World from bean");
  }

  @GetMapping("/hwBean/{name}")
  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
    return new HelloWorldBean(String.format("Hello, %s", name));
  }

  @GetMapping("/hwBeanInt")
  public String helloWorldInternational() {
    return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
  }
}
