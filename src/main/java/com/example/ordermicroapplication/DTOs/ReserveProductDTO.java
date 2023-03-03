package com.example.ordermicroapplication.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReserveProductDTO implements Serializable {
    private String id;
    private String name;
    private String category;

    private BigDecimal price;

    @JsonProperty("inStock")
    private Integer inStock;

    @JsonProperty("reservedQuantity")
    private Integer reservedQuantity;

    @JsonProperty("available")
    private Boolean available;
}
