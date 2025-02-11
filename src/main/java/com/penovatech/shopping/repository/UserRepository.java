package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractJpaRepository;
import com.penovatech.shopping.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractJpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
