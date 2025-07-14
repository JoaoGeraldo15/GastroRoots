package com.gastro.roots.api.model;

import com.gastro.roots.domain.dto.KitchenDTO;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class RestaurantSummaryDTO {

    private Long id;
    private String name;
    private BigDecimal deliveryFee;
    private Boolean isActive;
    private Boolean isOpen;
    private OffsetDateTime registrationDate;
    private OffsetDateTime updateDate;
    private KitchenDTO kitchen;

}
