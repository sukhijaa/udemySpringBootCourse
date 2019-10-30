package com.sukhijaa.springrest.sukhijaaspringbootrest.helloworld;

public class HelloWorldBean {

  private String message;

  public HelloWorldBean(String beanMsg) {
    this.message = beanMsg;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String beanMsg) {
    message = beanMsg;
  }
}
