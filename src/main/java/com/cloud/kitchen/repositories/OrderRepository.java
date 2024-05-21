package com.cloud.kitchen.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cloud.kitchen.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,String>{

    @Query(value = "SELECT * FROM customer_orders WHERE userId = :userId", nativeQuery = true)
    List<Order> getAllOrderHistory(@Param("userId") long userId);

    @Query(value = "SELECT * FROM customer_orders WHERE customer_order_id = :customerOrderId", nativeQuery = true)
    Order findOrderById(@Param("customerOrderId") String customerOrderId);



}
