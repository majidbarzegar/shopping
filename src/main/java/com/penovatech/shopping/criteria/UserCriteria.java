package com.penovatech.shopping.criteria;

import com.penovatech.common.model.AbstractCriteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCriteria extends AbstractCriteria<Long> {
    private String email;
}
