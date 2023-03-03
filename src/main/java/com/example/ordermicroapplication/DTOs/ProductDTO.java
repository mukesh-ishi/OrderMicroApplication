package com.example.ordermicroapplication.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private String id;

    private String name;

    private String category;

    private BigDecimal price;

    @JsonProperty("in_stock")
    private Integer inStock;

    @JsonProperty("reserved_quantity")
    private Integer reservedQuantity;

    @JsonProperty("is_available")
    private Boolean available;
}
