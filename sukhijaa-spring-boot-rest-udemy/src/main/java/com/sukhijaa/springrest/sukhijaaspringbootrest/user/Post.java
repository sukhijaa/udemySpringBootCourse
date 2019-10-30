package com.sukhijaa.springrest.sukhijaaspringbootrest.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

  @Id
  @GeneratedValue
  private Integer id;
  private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private UserBean user;

  public Post() {
  }

  public Post(String description, UserBean user) {
    super();
    this.description = description;
    this.user = user;
  }

  public Integer getId() {
    return id;
  }

  public String getDescription() {
    return description;
  }

  public UserBean getUser() {
    return user;
  }

  public void setUser(UserBean user) {
    this.user = user;
  }
}
