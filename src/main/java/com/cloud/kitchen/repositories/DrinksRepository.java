package com.cloud.kitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.kitchen.model.Drinks;

@Repository
public interface DrinksRepository extends JpaRepository<Drinks,Long>{
    
}
