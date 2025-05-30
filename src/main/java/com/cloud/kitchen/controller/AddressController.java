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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.kitchen.model.Address;
import com.cloud.kitchen.request.AddressRequest;
import com.cloud.kitchen.service.AddressService;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "[4] Address Controller")
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    public String getMethodName(@RequestParam String param) {
        return new String();
    }

    @GetMapping
    public ResponseEntity<?> getAllAddress() {

        return ResponseEntity.ok(addressService.getAllAddress());
    }

    @GetMapping(path = "/{addressId}")
    public ResponseEntity<?> getAddress(long addressId) {

        return ResponseEntity.ok(addressService.getAddress(addressId));
    }

    @DeleteMapping(path = "/{addressId}")
    public ResponseEntity<?> deleteAddress(long addressId) {
        addressService.deleteAddress(addressId);
        if (addressService.getAddress(addressId) != null) {
            ResponseEntity.ok("Addreess deletion is UnSuccessful!");
        }
        return ResponseEntity.ok("Address deleted Succussfully!");
    }

    @PostMapping
    public ResponseEntity<?> insertAddress(@RequestBody AddressRequest addressRequest) {

        Address address = addressService.insertAddress(addressRequest);

        if (address == null) {
            throw new RuntimeException("Create Address failed!");
        }

        return ResponseEntity.ok(address);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<?> updateAddress(@PathVariable long addressId, @RequestBody AddressRequest addressRequest) {

        Address address = addressService.updateAddres(addressId,addressRequest);

        if (address == null) {
            throw new RuntimeException("Create Address failed!");
        }

        return ResponseEntity.ok(address);
    }

}
