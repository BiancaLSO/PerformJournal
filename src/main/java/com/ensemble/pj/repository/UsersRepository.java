package com.ensemble.pj.repository;

import com.ensemble.pj.domain.UserEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByUsername(String username);
    UserEntity findUserEntityById(UUID uuid);
    void deleteById(UUID uuid);
}
