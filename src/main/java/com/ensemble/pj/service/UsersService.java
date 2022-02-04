package com.ensemble.pj.service;

import static com.ensemble.pj.domain.UserEntity.toUser;
import static com.ensemble.pj.exception.ErrorCode.OBJECT_ALREADY_EXISTS;

import com.ensemble.pj.domain.UserEntity;
import com.ensemble.pj.dto.User;
import com.ensemble.pj.exception.UserServiceException;
import com.ensemble.pj.repository.UsersRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

  @Autowired
  protected UsersRepository userFinderRepository;

  @Autowired
  private PasswordEncoder bCryptPasswordEncoder;

  public User createUser(User user) {
    UserEntity existingUser = userFinderRepository.findByUsername(user.getUsername());

    if (existingUser != null) {
      throw new UserServiceException(OBJECT_ALREADY_EXISTS, "User with specified username already exists");
    }

    // Generate random string token for id
    String id = UUID.randomUUID().toString();

    UserEntity userEntity = new UserEntity();
    userEntity.setId(id);
    userEntity.setUsername(user.getUsername());
    userEntity.setFirstName(user.getFirstName());
    userEntity.setLastName(user.getLastName());
    userEntity.setRoles(user.getRoles());

    // Encode password
    if (user.getPassword() != null) {
      userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    }

    UserEntity saveUser = userFinderRepository.saveAndFlush(userEntity);

    return toUser(saveUser);
  }

  public List<User> getAllUsers() {
    List<UserEntity> userEntities = userFinderRepository.findAll();
    List<User> users = new ArrayList<>();

    for (UserEntity userEntity : userEntities) {
      users.add(toUser(userEntity));
    }
    return users;
  }

  public User getUserById(String id){
    UserEntity userEntity = userFinderRepository.findUserEntityById(UUID.fromString(id));
    return toUser(userEntity);
  }

  public void deleteUser(String id){
    userFinderRepository.deleteById(UUID.fromString(id));
  }

}
