package com.cloud.kitchen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cloud.kitchen.model.DrinksOrderItem;
import com.cloud.kitchen.model.FoodOrderItem;

@Repository
public interface DrinksOrderItemRepositories extends JpaRepository<DrinksOrderItem,Long>{

    @Query(value = "SELECT * FROM drinks_order_item WHERE customer_order_id = :orderId", nativeQuery = true)
    List<FoodOrderItem> getAllFoodOrderItems(@Param("orderId") String orderId);

}
