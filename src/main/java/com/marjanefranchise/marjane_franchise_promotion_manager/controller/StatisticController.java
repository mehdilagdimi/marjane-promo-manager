package com.marjanefranchise.marjane_franchise_promotion_manager.controller;

import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Center;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Manager;
import com.marjanefranchise.marjane_franchise_promotion_manager.entity.Promotion;
import com.marjanefranchise.marjane_franchise_promotion_manager.util.EmailService.SimpleEmail;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;


public class StatisticController {

    public String getPromotionStatusPercentages(){
        String param = "status";
        String queryName = "countAcceptedPromotions";
        long acceptedCount = BeanController.namedQueryCount(Promotion.class, queryName, param, "accepter");
        long refusedCount = BeanController.namedQueryCount(Promotion.class, queryName, param, "refuse");
        long waitingCount = BeanController.namedQueryCount(Promotion.class, queryName, param, "en cours");
        long[] counts = {acceptedCount, refusedCount, waitingCount};
        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("[");
        for(long c : counts){
//            stringBuilder.append("\"");
            stringBuilder.append(c);
            stringBuilder.append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
//        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
