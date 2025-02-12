package com.penovatech.shopping.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
    @JsonProperty("page_number")
    private Integer pageNumber;

    @JsonProperty("total_rows")
    private Long totalRows;

    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("has_previous_page")
    private Boolean hasPreviousPage;

    @JsonProperty("has_next_page")
    private Boolean hasNextPage;
}
