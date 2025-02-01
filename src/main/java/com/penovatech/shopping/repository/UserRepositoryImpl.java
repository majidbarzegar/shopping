package com.penovatech.shopping.repository;

import com.penovatech.common.base.PredicateBuilder;
import com.penovatech.common.base.repository.AbstractRepositoryImpl;
import com.penovatech.shopping.criteria.UserCriteria;
import com.penovatech.shopping.model.User;
import com.penovatech.shopping.model.User_;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Repository
public class UserRepositoryImpl extends AbstractRepositoryImpl<User, UserCriteria, Long> implements UserRepository {
    @Override
    protected void addCondition(PredicateBuilder<User> predicateBuilder, UserCriteria criteria) {
        predicateBuilder.addCondition(
                (criteriaBuilder, r) -> criteriaBuilder.equal(r.get(User_.EMAIL), criteria.getEmail()),
                StringUtils.hasLength(criteria.getEmail())
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {
        UserCriteria criteria = new UserCriteria();
        criteria.setEmail(email);
        return this.getFirst(criteria);
    }
}
