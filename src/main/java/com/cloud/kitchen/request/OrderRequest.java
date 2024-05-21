package com.cloud.kitchen.request;

import java.util.List;

import com.cloud.kitchen.model.DrinksOrderItem;
import com.cloud.kitchen.model.FoodOrderItem;

public class OrderRequest {

        private List<DrinksOrderItem> drinksOrderItems;
        private List<FoodOrderItem> foodOrderItems;

        private double totalPrice;

        private long userId;

        private boolean isDelivered;

        private boolean isDispatched;

        public OrderRequest(List<FoodOrderItem> foodOrderItems, List<DrinksOrderItem> drinksOrderItems
                , long userId,boolean isDelivered,boolean isDispatched) {

            this.foodOrderItems = foodOrderItems;
            this.drinksOrderItems = drinksOrderItems;
            // this.totalPrice = totalPrice;
            this.userId = userId;
            
            this.isDelivered=isDelivered;
            this.isDispatched=isDispatched;

        }

}
