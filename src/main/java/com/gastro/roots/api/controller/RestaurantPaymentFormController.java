package com.gastro.roots.api.controller;

import com.gastro.roots.domain.dto.PaymentFormDTO;
import com.gastro.roots.domain.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("restaurants/{restaurantId}/payment-form")
@RequiredArgsConstructor
public class RestaurantPaymentFormController {
    
    private final RestaurantService service;

    @GetMapping
    public ResponseEntity<Set<PaymentFormDTO>> list(@PathVariable Long restaurantId) {
        return ResponseEntity.ok(service.listPaytmentsForm(restaurantId));
    }
}
