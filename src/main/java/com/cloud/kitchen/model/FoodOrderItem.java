package com.cloud.kitchen.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class FoodOrderItem implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long foodOrderItemId;

    // @ManyToOne
    // @JoinColumn(name = "order_id")
    // private Order order;

    @Column(name = "customer_order_id", nullable = false, columnDefinition = "VARCHAR(255)")
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "food_item_id")
    private Item foodItem;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    public FoodOrderItem(Item foodItem, int quantity,String orderId) {
        this.foodItem = foodItem;
        this.quantity = quantity;
        this.orderId=orderId;
    }

}
