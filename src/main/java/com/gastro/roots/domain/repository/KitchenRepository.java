package com.gastro.roots.domain.repository;

import com.gastro.roots.domain.entity.Kitchen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
}
