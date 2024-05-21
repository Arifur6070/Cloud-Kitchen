package com.cloud.kitchen.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    @NoArgsConstructor
    @Getter
    @Setter
    @Entity(name="customer_orders")
    public class Order implements Serializable{

        @Id
        // @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "customer_order_id", nullable = false, columnDefinition = "VARCHAR(255)")
        private String orderId=UUID.randomUUID().toString();

        // @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
        // @JsonIgnoreProperties("order") 
        private List<FoodOrderItem> foodOrderItems;

        // @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
        // @JsonIgnoreProperties("order") 
        private List<DrinksOrderItem> drinksOrderItems;

        private double totalPrice;

        private String userId;

        private LocalDateTime orderDateTime;

        private boolean isDelivered;

        private boolean isDispatched;

        public Order(List<FoodOrderItem> foodOrderItems, List<DrinksOrderItem> drinksOrderItems
                , String userId, LocalDateTime orderDateTime,boolean isDelivered,boolean isDispatched) {

            this.foodOrderItems = foodOrderItems;
            this.drinksOrderItems = drinksOrderItems;
            // this.totalPrice = totalPrice;
            this.userId = userId;
            this.orderDateTime = orderDateTime;
            this.isDelivered=isDelivered;
            this.isDispatched=isDispatched;

        }


        public void addFoodOrderItem(FoodOrderItem foodOrderItem) {
            foodOrderItem.setOrderId(this.getOrderId());
            this.foodOrderItems.add(foodOrderItem);
        }
    
        // public void removeFoodOrderItem(FoodOrderItem foodOrderItem) {
        //     foodOrderItem.setOrderId(null);
        //     this.foodOrderItems.remove(foodOrderItem);
        // }
    
        public void addDrinksOrderItem(DrinksOrderItem drinksOrderItem) {
            drinksOrderItem.setOrderId(this.getOrderId());
            this.drinksOrderItems.add(drinksOrderItem);
        }
    
        // public void removeDrinksOrderItem(DrinksOrderItem drinksOrderItem) {
        //     drinksOrderItem.setOrder(null);
        //     this.drinksOrderItems.remove(drinksOrderItem);
        // }

    }
