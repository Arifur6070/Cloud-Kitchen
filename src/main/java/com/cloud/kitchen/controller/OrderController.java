package com.cloud.kitchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.kitchen.model.Order;
import com.cloud.kitchen.service.OrderService;

import io.swagger.v3.oas.annotations.tags.Tag;




@Tag(name = "[1] Order Controller")
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    
    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
    

    @GetMapping("/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable String orderId) {
        if (orderService.getOrder(orderId) == null) {
            throw new RuntimeException("Order not found");
        }
        return ResponseEntity.ok(orderService.getOrder(orderId));
    }

    @GetMapping("/{userId}/order-history")
    public ResponseEntity<?> getOrderHistory(@PathVariable long userId) {
        if (orderService.getOrderHistory(userId) == null) {
            throw new RuntimeException("Order History not found");
        }
        return ResponseEntity.ok(orderService.getOrderHistory(userId));
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable String orderId){
        if (orderService.getOrder(orderId) == null) {
            throw new RuntimeException("Order not found");
        }

        return ResponseEntity.ok(orderService.getOrder(orderId));
    }


    @PostMapping
    public ResponseEntity<?> insertOrder(@RequestBody Order order) {
        Order Createdorder = orderService.createOrder(order);
        if (Createdorder == null) {
            throw new RuntimeException("Order Creating failed!!");
        }
        return ResponseEntity.ok(Createdorder);
    }  

    @PutMapping("/{orderId}")
    public ResponseEntity<?> UpdateOrder(@RequestBody Order order,@PathVariable String orderId) {
        Order oldOrder = orderService.getOrder(orderId);
        if (oldOrder == null) {
            throw new RuntimeException("Order Not found");
        }
        if (oldOrder.isDelivered() == true) {
            throw new RuntimeException("Order is delivered already!!");
        }
        if (oldOrder.isDispatched() == true) {
            throw new RuntimeException("Order is dispatched!! Cannot be changed");
        }

        oldOrder=orderService.updateOrder(order, orderId);
        return ResponseEntity.ok(oldOrder);
    }

}
