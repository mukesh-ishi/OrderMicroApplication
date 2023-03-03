package com.example.ordermicroapplication.service;




import com.example.ordermicroapplication.DTOs.ProductDTO;
import com.example.ordermicroapplication.DTOs.ReserveProductDTO;
import com.example.ordermicroapplication.utils.NotificationSenderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;



@Service
public class OrderServiceImpl implements OrderService{

//   @Autowired
//   OrderRepository orderRepository;


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public ProductDTO getOrder(String Id) {
        RestTemplate restTemplate=new RestTemplate();
        String url="http://localhost:8051/products/getById/";
        ResponseEntity<ProductDTO> response =restTemplate.getForEntity(url+"/"+Id, ProductDTO.class);
        ProductDTO productDTO=response.getBody();
        System.out.println(productDTO);
        return productDTO;
    }
    @Override
    public ReserveProductDTO placeOrderDetail(String Id, Integer reserveQauntity) {
        RestTemplate restTemplate=new RestTemplate();
        String url="http://localhost:8051/products/update/";
        ResponseEntity<ReserveProductDTO> response =restTemplate.exchange(url+"/"+Id+"/"+reserveQauntity, HttpMethod.PUT,null,ReserveProductDTO.class);
        ReserveProductDTO reserveProductDTO=response.getBody();
        Integer quantity=reserveProductDTO.getReservedQuantity();
        BigDecimal bd = BigDecimal.valueOf(quantity);
        BigDecimal bigDecimal=reserveProductDTO.getPrice();
        BigDecimal b3 = bigDecimal.multiply(bd);
        reserveProductDTO.setPrice(b3);
        kafkaTemplate.send("Order_Notification", NotificationSenderUtils.generateNotificationBody(reserveProductDTO));
        return reserveProductDTO;

    }

}
