package com.gastro.roots.domain.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String zipCode;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String cityName;
}
