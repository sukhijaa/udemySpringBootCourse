package com.sukhijaa.springrest.sukhijaaspringbootrest.user;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class UserBean {

  @Id
  @GeneratedValue
  private int id;

  @Size(min = 2, max = 120, message = "Name should be longer than 2 and less than 120 characters")
  private String name;

  @Past(message = "Birth Date should be a past value")
  private Date dateOfBirth;

  @OneToMany(mappedBy = "user")
  private List<Post> allPosts;

  UserBean() {
    this(-1, null, null);
  }

  UserBean(String name, Date dateOfBirth) {
    this(-1, name, dateOfBirth);
  }

  UserBean(int id, String name, Date dateOfBirth) {
    super();
    this.id = id;
    this.name = name;
    this.dateOfBirth = dateOfBirth;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public List<Post> getAllPosts() {
    return allPosts;
  }
}
