package com.sukhijaa.springrest.sukhijaaspringbootrest.user;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sukhijaa.springrest.sukhijaaspringbootrest.exception.UserNotFoundException;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController()
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/users")
  public List<UserBean> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/users-filtered")
  public MappingJacksonValue getAllUsersFilteredData() {
    List<UserBean> myList = userService.getAllUsers();

    SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.serializeAllExcept("id");
    FilterProvider filters = new SimpleFilterProvider().addFilter("idMask", myFilter);
    MappingJacksonValue mapper = new MappingJacksonValue(myList);
    mapper.setFilters(filters);

    return mapper;
  }

  @GetMapping("/users/{id}")
  public UserBean getDesiredUser(@PathVariable int id) {
    UserBean foundRes = userService.getSingleUserById(id);
    if (foundRes == null) {
      throw new UserNotFoundException("No user found for id : " + String.valueOf(id));
    }

//    EntityModel<UserBean> myUserModel = new EntityModel<>(foundRes);
//    WebMvcLinkBuilder linkTo = WebMvcLinkBuilder
//        .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
//    myUserModel.add(linkTo.withRel("all_users"));
//
//    return myUserModel;

    return foundRes;
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createNewUser(@RequestBody @Valid UserBean user) {
    UserBean addedUser = userService.addUser(user);

    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(addedUser.getId()).toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<Object> deleteUser(@PathVariable int id) {
    UserBean deletedUser = userService.deleteUser(id);
    if (deletedUser == null) {
      throw new UserNotFoundException("No user found for id : " + String.valueOf(id));
    }

    return ResponseEntity.noContent().build();
  }
}
