package com.cloud.kitchen.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class AddressRequest {
    private String addressType;
    private String roadName;
    private int houseNumber;
    private int postalCode;
    private String cityName;
    private String countryName;
    private long userId;

    public AddressRequest(String addressType, String roadName,
     int houseNumber, int postalCode, String cityName,
     String countryName, long userId) {
        this.addressType = addressType;
        this.roadName = roadName;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.cityName = cityName;
        this.countryName = countryName;
        this.userId = userId;
    }




}
