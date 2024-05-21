package com.cloud.kitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloud.kitchen.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    
}
