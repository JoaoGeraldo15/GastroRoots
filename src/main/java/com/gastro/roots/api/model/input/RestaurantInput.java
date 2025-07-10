package com.gastro.roots.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class RestaurantInput {

    @NotBlank
    private String name;

    @NotNull
    @PositiveOrZero
    private BigDecimal deliveryFee;

    @NotNull
    private Long kitchenId;

    @NotNull
    @Valid
    private List<AddressInput> addresses;
}