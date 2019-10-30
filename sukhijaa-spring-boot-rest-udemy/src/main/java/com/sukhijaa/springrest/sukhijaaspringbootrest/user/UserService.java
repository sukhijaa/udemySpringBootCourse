package com.sukhijaa.springrest.sukhijaaspringbootrest.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.springframework.stereotype.Component;

@Component
public class UserService {

  private static ArrayList<UserBean> allUsers = new ArrayList<UserBean>();

  static {
    allUsers.add(new UserBean(1, "Abhishek", new Date()));
    allUsers.add(new UserBean(2, "Sukhija", new Date()));
  }

  private int idCounter = 2;

  public ArrayList<UserBean> getAllUsers() {
    return allUsers;
  }

  public UserBean getSingleUserById(int id) {
    for (UserBean curUser : allUsers) {
      if (curUser.getId() == id) {
        return curUser;
      }
    }
    return null;
  }

  public UserBean addUser(UserBean user) {
    if (user.getId() == -1) {
      user.setId(++idCounter);
    }
    allUsers.add(user);
    return user;
  }

  public UserBean deleteUser(int id) {
    Iterator<UserBean> i = allUsers.iterator();
    while (i.hasNext()) {
      UserBean usr = i.next();
      if (usr.getId() == id) {
        return usr;
      }
    }

    return null;
  }

}
