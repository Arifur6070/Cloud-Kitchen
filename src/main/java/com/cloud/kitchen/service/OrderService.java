package com.cloud.kitchen.service;

import java.time.LocalDateTime;
// import org.hibernate.validator.constraints.UUID;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.kitchen.model.Drinks;
import com.cloud.kitchen.model.DrinksOrderItem;
import com.cloud.kitchen.model.FoodOrderItem;
import com.cloud.kitchen.model.Order;
import com.cloud.kitchen.repositories.DrinksOrderItemRepositories;
import com.cloud.kitchen.repositories.DrinksRepository;
import com.cloud.kitchen.repositories.FoodOrderItemRepository;
import com.cloud.kitchen.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    DrinksRepository drinkRepository;

    @Autowired
    FoodOrderItemRepository foodOrderItemRepository;

    @Autowired
    DrinksOrderItemRepositories drinksOrderItemRepositories;

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }

    public Order getOrder(String orderId) {

        return orderRepository.findOrderById(orderId);
    }


    public void deleteOrder(String orderId){

        if (getOrder(orderId) == null){
            throw new RuntimeException("Order Not found!!");
        }

        orderRepository.deleteById(orderId);
    }


    public List<Order> getOrderHistory(long userId){

        return orderRepository.getAllOrderHistory(userId);
    }


     public Order createOrder(Order order) {
        // Calculate total price
        double totalPrice = calculateTotalPrice(order);

        // Update stock and save drinks
        

        String orderId = UUID.randomUUID().toString();

        // Set total price and save order
        order.setTotalPrice(totalPrice);
        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderId(orderId);

        savingOrderItems(order);
        updateDrinksStock(order);

        orderRepository.save(order);

        return order;
    }

    private void savingOrderItems(Order order) {
        for (int i = 0; i < order.getFoodOrderItems().size(); i++) {
            order.getFoodOrderItems().get(i).setOrderId(order.getOrderId());
            foodOrderItemRepository.save(order.getFoodOrderItems().get(i));

        }
        for (int i = 0; i < order.getDrinksOrderItems().size(); i++) {
            order.getDrinksOrderItems().get(i).setOrderId(order.getOrderId());
            drinksOrderItemRepositories.save(order.getDrinksOrderItems().get(i));

        }
    }

    public Order updateOrder(Order order, String orderId) {
        // Check if order is already dispatched
        if (orderRepository.findOrderById(orderId).isDispatched()) {
            throw new RuntimeException("Order is already dispatched and cannot be changed.");
        }

        // Calculate total price
        double totalPrice = calculateTotalPrice(order);

        // Update stock and save drinks
        

        // Set total price and save order
        order.setTotalPrice(totalPrice);

        order.setOrderDateTime(LocalDateTime.now());
        updateDrinksStock(order);
        orderRepository.save(order);

        return order;
    }

    private double calculateTotalPrice(Order order) {
        double totalPrice = 0;

        for (FoodOrderItem foodOrderItem : order.getFoodOrderItems()) {
            totalPrice += foodOrderItem.getFoodItem().getPrice() * foodOrderItem.getQuantity();
            // foodOrderItem.setOrderId(order);
        }

        for (DrinksOrderItem drinksOrderItem : order.getDrinksOrderItems()) {
            totalPrice += drinksOrderItem.getDrink().getDrinkPrice() * drinksOrderItem.getQuantity();
        }

        return totalPrice;
    }

    private void updateDrinksStock(Order order) {

        for (int i = 0; i < order.getDrinksOrderItems().size(); i++) {
            int previousStock = drinkRepository.findById(order.getDrinksOrderItems().get(i).getDrink().getDrinkId()).get().getStock();
            int quantity = order.getDrinksOrderItems().get(i).getQuantity();

            int newStock = previousStock-quantity;

            // System.out.println("New Stock "+newStock);
            logger.debug("New Stock"+newStock);

            Drinks updateDrinks = drinkRepository.findById(order.getDrinksOrderItems().get(i).getDrink().getDrinkId()).get();

            updateDrinks.setStock(newStock);

            drinkRepository.save(updateDrinks);
            
        }



    }


}
