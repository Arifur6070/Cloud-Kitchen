package com.cloud.kitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.kitchen.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
    
}
