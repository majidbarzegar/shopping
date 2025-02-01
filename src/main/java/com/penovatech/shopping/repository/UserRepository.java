package com.penovatech.shopping.repository;

import com.penovatech.common.base.repository.AbstractRepository;
import com.penovatech.shopping.criteria.UserCriteria;
import com.penovatech.shopping.model.User;

import java.util.Optional;

public interface UserRepository extends AbstractRepository<User, UserCriteria, Long> {
    Optional<User> findByEmail(String email);
}
