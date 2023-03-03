package com.example.ordermicroapplication.utils;



import com.example.ordermicroapplication.DTOs.ReserveProductDTO;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class NotificationSenderUtils {
    public static String generateNotificationBody(ReserveProductDTO reserveProductDTO) {
        //Notification after creating or adding new Product

        String moneyString = properMoneyFormat(reserveProductDTO.getPrice());

        return "YOUR ORDER IS PLACED! \n" +
                " "+reserveProductDTO.getName() + " (" +reserveProductDTO.getCategory()+ ")"+"\n" +
                "Qauntity Size:"+reserveProductDTO.getReservedQuantity()+"\n"+
                "Total-Price : Rs " + moneyString ;

    }

    public static String properMoneyFormat(BigDecimal price) {//Currency Formatter
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        return decimalFormat.format(price);
    }
}
