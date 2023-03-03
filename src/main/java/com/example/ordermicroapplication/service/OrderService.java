package com.example.ordermicroapplication.service;


//import com.example.orderproductmicroservices.entity.OrderEntity;
//import com.example.orderproductmicroservices.entity.ProductEntity;
//import com.example.orderproductmicroservices.entity.OrderEntity;

import com.example.ordermicroapplication.DTOs.ProductDTO;
import com.example.ordermicroapplication.DTOs.ReserveProductDTO;
import org.springframework.stereotype.Service;


public interface OrderService {
    ProductDTO getOrder(String Id);

    ReserveProductDTO placeOrderDetail(String Id, Integer reserveQauntity);
   // OrderResponseDto getOrderDetails(long orderId);
}
