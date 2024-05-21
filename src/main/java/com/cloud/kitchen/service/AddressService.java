package com.cloud.kitchen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.kitchen.Auth.model.User;
import com.cloud.kitchen.model.Address;
import com.cloud.kitchen.model.enm.AddressType;
import com.cloud.kitchen.repositories.AddressRepository;
import com.cloud.kitchen.repositories.UserRepository;
import com.cloud.kitchen.request.AddressRequest;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Address> getAllAddress() {

        return addressRepository.findAll();
    }

    public Address getAddress(long addressId) {

        Optional<Address> addressWrapper = addressRepository.findById(addressId);

        if (addressWrapper == null) {
            throw new RuntimeException("Address not found!");
        }

        return addressWrapper.get();

    }

    public Address insertAddress(AddressRequest addressRequest) {

        Optional<User> userWrapper = userRepository.findById(addressRequest.getUserId());

        if (userWrapper == null) {
            System.out.println("I am here");
            throw new RuntimeException("No user found with this id");
        }

        User user = userWrapper.get();
        Address address = new Address();

        if (addressRequest.getAddressType().toLowerCase().equals("delivery")) {

            address = new Address(AddressType.DELIVERY_ADDRESS,
                    addressRequest.getRoadName(),
                    addressRequest.getHouseNumber(),
                    addressRequest.getPostalCode(),
                    addressRequest.getCityName(),
                    addressRequest.getCountryName(),
                    user);

        } else if (addressRequest.getAddressType().toLowerCase().equals("billing")) {
            address = new Address(AddressType.BILLING_ADDRESS,
                    addressRequest.getRoadName(),
                    addressRequest.getHouseNumber(),
                    addressRequest.getPostalCode(),
                    addressRequest.getCityName(),
                    addressRequest.getCountryName(),
                    user);
        } else {
            address = new Address(AddressType.PERMANENT_ADDRESS,
                    addressRequest.getRoadName(),
                    addressRequest.getHouseNumber(),
                    addressRequest.getPostalCode(),
                    addressRequest.getCityName(),
                    addressRequest.getCountryName(),
                    user);
        }

        

        addressRepository.save(address);

        return address;
    }

    public Address updateAddres(long addressId, AddressRequest addressRequest) {

        Optional<Address> addressWrapper = addressRepository.findById(addressId);

        if (addressWrapper == null) {
            throw new RuntimeException("No address found with this id");
        }

        Address address = addressWrapper.get();

        if (addressRequest.getAddressType().toLowerCase().equals("delivery_address")) {

            address.setAddressType(AddressType.DELIVERY_ADDRESS);
            address.setHouseNumber(addressRequest.getHouseNumber());
            address.setRoadName(addressRequest.getRoadName());
            addressRequest.setPostalCode(addressRequest.getPostalCode());
            address.setCityName(addressRequest.getCityName());
            address.setCountryName(addressRequest.getCountryName());

        } else if (addressRequest.getAddressType().toLowerCase().equals("billing_address")) {
            address.setAddressType(AddressType.BILLING_ADDRESS);
            address.setHouseNumber(addressRequest.getHouseNumber());
            address.setRoadName(addressRequest.getRoadName());
            addressRequest.setPostalCode(addressRequest.getPostalCode());
            address.setCityName(addressRequest.getCityName());
            address.setCountryName(addressRequest.getCountryName());
        } else {
            address.setAddressType(AddressType.PERMANENT_ADDRESS);
            address.setHouseNumber(addressRequest.getHouseNumber());
            address.setRoadName(addressRequest.getRoadName());
            addressRequest.setPostalCode(addressRequest.getPostalCode());
            address.setCityName(addressRequest.getCityName());
            address.setCountryName(addressRequest.getCountryName());
        }

        addressRepository.save(address);

        return address;
    }

    public void deleteAddress(long addressId) {

        Optional<Address> addressWrapper = addressRepository.findById(addressId);

        if (addressWrapper == null) {
            throw new RuntimeException("Address not found!");
        }

        addressRepository.deleteById(addressId);

    }

}
