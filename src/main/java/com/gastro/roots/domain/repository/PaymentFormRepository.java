package com.gastro.roots.domain.repository;

import com.gastro.roots.domain.entity.PaymentForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentFormRepository extends JpaRepository<PaymentForm, Long> {
}
