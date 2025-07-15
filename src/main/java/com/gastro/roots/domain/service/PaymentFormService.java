package com.gastro.roots.domain.service;

import com.gastro.roots.domain.entity.PaymentForm;

public interface PaymentFormService {
    /**
     * Returns a paymentForm according an id passed
     *
     * @param paymentFormId id to retreives the payment
     * @return PaymentForm
     */
    PaymentForm findEntityById(Long paymentFormId);
}
