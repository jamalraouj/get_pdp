package com.get_pdp.get_pdp.repository;

import com.get_pdp.get_pdp.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository  extends JpaRepository<UserEntity , Long> {
    public Optional<UserEntity> findUserEntityByEmail(String email);
}
