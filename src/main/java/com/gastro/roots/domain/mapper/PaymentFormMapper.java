package com.gastro.roots.domain.mapper;

import com.gastro.roots.domain.dto.PaymentFormDTO;
import com.gastro.roots.domain.entity.PaymentForm;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface PaymentFormMapper {

    PaymentFormDTO toDTO(PaymentForm entity);

    Set<PaymentFormDTO> toDTO(Set<PaymentForm> entity);
}
