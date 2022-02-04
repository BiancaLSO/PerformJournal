package com.ensemble.pj.api;

import com.ensemble.pj.dto.User;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UsersApi {

  @RequestMapping(value = "/users",
      produces = { "application/json" },
      consumes = { "application/json" },
      method = RequestMethod.PUT)
  ResponseEntity<User> createUser(@RequestBody User body);

  @RequestMapping(value = "/users",
      produces = { "application/json" },
      method = RequestMethod.GET)
  ResponseEntity <List<User>> getAllUsers();

  @RequestMapping(value="/users/delete/{id}", method = RequestMethod.DELETE)
  ResponseEntity<User> deleteUser(@PathVariable("id") String id);
}
