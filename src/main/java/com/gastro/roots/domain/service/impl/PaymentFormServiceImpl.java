package com.gastro.roots.domain.service.impl;

import com.gastro.roots.domain.entity.PaymentForm;
import com.gastro.roots.domain.repository.PaymentFormRepository;
import com.gastro.roots.domain.service.PaymentFormService;
import com.gastro.roots.domain.service.exception.PaymentFormNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PaymentFormServiceImpl implements PaymentFormService {

    private final PaymentFormRepository repository;

    @Override
    @Transactional(readOnly = true)
    public PaymentForm findEntityById(Long paymentFormId) {
        return repository.findById(paymentFormId)
                .orElseThrow(() -> new PaymentFormNotFoundException(paymentFormId));
    }

}
