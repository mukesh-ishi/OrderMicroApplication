package com.example.ordermicroapplication.controller;


import com.example.ordermicroapplication.DTOs.ProductDTO;
import com.example.ordermicroapplication.DTOs.ReserveProductDTO;
import com.example.ordermicroapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import static com.example.orderproductmicroservices.utils.MapperUtils.toProductDTO;

@RestController
@RequestMapping("/Orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/get/{Id}")
    public ResponseEntity<ProductDTO> placeOrderd(@PathVariable String Id){

       ProductDTO productDTO=orderService.getOrder(Id);
       return new ResponseEntity<ProductDTO>(productDTO, HttpStatus.OK);
    }


    @PutMapping("/reserve/{ID}/{reserveQuantity}")
    public ResponseEntity<ReserveProductDTO> reserveProductDetail(@PathVariable(name="ID") String ID,
                                                                      @PathVariable(name="reserveQuantity")
                                                                              Integer reserveQuantity)
    {
        ReserveProductDTO reserveProductDTO=orderService.placeOrderDetail(ID,reserveQuantity);
        return new ResponseEntity<ReserveProductDTO>(reserveProductDTO,HttpStatus.OK);
    }

}
