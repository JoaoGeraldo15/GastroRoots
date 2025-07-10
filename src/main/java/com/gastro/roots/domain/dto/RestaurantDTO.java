package com.gastro.roots.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RestaurantDTO {

    private Long id;
    private String name;
    private BigDecimal deliveryFee;
    private Boolean isActive;
    private Boolean isOpen;
    private LocalDateTime registrationDate;
    private LocalDateTime updateDate;
    private KitchenDTO kitchen;
    private List<AddressDTO> addresses;

}
