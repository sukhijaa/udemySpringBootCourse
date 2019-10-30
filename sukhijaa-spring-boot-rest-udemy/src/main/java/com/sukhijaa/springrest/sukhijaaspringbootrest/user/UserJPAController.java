package com.sukhijaa.springrest.sukhijaaspringbootrest.user;

import com.sukhijaa.springrest.sukhijaaspringbootrest.exception.UserNotFoundException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserJPAController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @GetMapping("/jpa/users")
  public List<UserBean> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/jpa/users/{id}")
  public UserBean getSingleUser(@PathVariable int id) {
    Optional<UserBean> foundUser = userRepository.findById(id);

    if (!foundUser.isPresent()) {
      throw new UserNotFoundException("User not found with id " + String.valueOf(id));
    }

    return foundUser.get();
  }

  @DeleteMapping("/jpa/users/{id}")
  public void deleteSingleUser(@PathVariable int id) {
    userRepository.deleteById(id);
  }

  @PostMapping("/jpa/users")
  public UserBean createNewUser(@RequestBody @Valid UserBean user) {
    UserBean usr = userRepository.save(user);
    return usr;
  }

  @GetMapping("/jpa/users/{id}/posts")
  public List<Post> getAllPostForAUser(@PathVariable int id) {
    Optional<UserBean> foundUser = userRepository.findById(id);
    if (!foundUser.isPresent()) {
      throw new UserNotFoundException("User not found with id " + String.valueOf(id));
    }

    return foundUser.get().getAllPosts();
  }

  @PostMapping("/jpa/users/{id}/posts")
  public Post createNewPostForUser(@PathVariable int id, @RequestBody Post post) {
    Optional<UserBean> foundUser = userRepository.findById(id);
    if (!foundUser.isPresent()) {
      throw new UserNotFoundException("User not found with id " + String.valueOf(id));
    }
    post.setUser(foundUser.get());
    postRepository.save(post);

    return post;
  }

  @DeleteMapping("/jpa/posts/{postId}")
  public void deletePostForAUser(@PathVariable int postId) {
    postRepository.deleteById(postId);
  }
}
