package com.ensemble.pj.controller;

import com.ensemble.pj.api.UsersApi;
import com.ensemble.pj.dto.User;
import com.ensemble.pj.service.UsersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class UsersController implements UsersApi {

  @Autowired
  private UsersService usersService;

  @Override
  public ResponseEntity<User> createUser(@RequestBody User body) {
    User user = usersService.createUser(body);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<List<User>> getAllUsers() {
    List<User> pizzas = usersService.getAllUsers();
    return new ResponseEntity<>(pizzas, HttpStatus.OK);
  }

  @Override
  @Transactional
  public ResponseEntity<User> deleteUser(String id) {
    usersService.deleteUser(id);
    User user = usersService.getUserById(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

}
