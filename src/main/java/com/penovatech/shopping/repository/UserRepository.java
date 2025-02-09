package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractJpaRepository;
import com.penovatech.shopping.model.User;

import java.util.Optional;

public interface UserRepository extends AbstractJpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
