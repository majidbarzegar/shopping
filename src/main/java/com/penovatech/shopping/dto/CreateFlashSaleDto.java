
package com.penovatech.shopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.penovatech.common.model.AbstractDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class CreateFlashSaleDto extends AbstractDto<Long> {
    @JsonProperty("expire_at")
    private OffsetDateTime expireAt;

    @JsonProperty("start_at")
    private OffsetDateTime startAt;

    @JsonProperty("productIds")
    private List<Long> productIdList;
}
