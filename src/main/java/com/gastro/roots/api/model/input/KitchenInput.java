package com.gastro.roots.api.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KitchenInput {

    @NotBlank
    private String name;
}
