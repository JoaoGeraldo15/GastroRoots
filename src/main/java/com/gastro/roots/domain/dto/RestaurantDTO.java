package com.gastro.roots.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Data
public class RestaurantDTO {

    private Long externalId;
    private String name;
    private BigDecimal deliveryFee;
    private Boolean isActive;
    private Boolean isOpen;
    private OffsetDateTime registrationDate;
    private OffsetDateTime updateDate;
    private KitchenDTO kitchen;
    private List<AddressDTO> addresses;

}
