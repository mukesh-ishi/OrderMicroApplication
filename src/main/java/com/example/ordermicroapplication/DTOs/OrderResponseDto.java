package com.example.ordermicroapplication.DTOs;

//import com.example.orderproductmicroservices.entity.ReserveProductEntity;


import com.example.ordermicroapplication.enums.StatusCategory;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto implements Serializable {

    private String orderId;
    private String productId;
    private BigDecimal price;
    private Integer reserveQauntity;
    private StatusCategory statusCategory;
    private Date date;
    private double totalAmount;
    private String address;
}
