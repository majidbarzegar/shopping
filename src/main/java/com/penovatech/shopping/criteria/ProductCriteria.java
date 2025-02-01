package com.penovatech.shopping.criteria;

import com.penovatech.common.model.AbstractCriteria;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductCriteria extends AbstractCriteria<Long> {
    private LocalDateTime createdDateFrom;
}
