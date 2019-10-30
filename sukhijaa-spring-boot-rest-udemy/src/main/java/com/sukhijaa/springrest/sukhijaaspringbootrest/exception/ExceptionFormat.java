package com.sukhijaa.springrest.sukhijaaspringbootrest.exception;

import java.util.Date;

public class ExceptionFormat {

  private Date timeStamp;
  private String message;
  private String description;

  public ExceptionFormat(Date time, String msg, String desc) {
    super();
    this.timeStamp = time;
    this.message = msg;
    this.description = desc;
  }

  public Date getTimeStamp() {
    return timeStamp;
  }

  public String getMessage() {
    return message;
  }

  public String getDescription() {
    return description;
  }
}
