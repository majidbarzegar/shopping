package com.penovatech.shopping.service;

import com.penovatech.common.base.service.AbstractService;
import com.penovatech.shopping.criteria.UserCriteria;
import com.penovatech.shopping.dto.RegisterRequest;
import com.penovatech.shopping.dto.UserDto;
import com.penovatech.shopping.model.User;

import java.util.Optional;

public interface UserService extends AbstractService<User, Long> {

    String register(RegisterRequest request);

    Optional<User> findByEmail(String email);
}
