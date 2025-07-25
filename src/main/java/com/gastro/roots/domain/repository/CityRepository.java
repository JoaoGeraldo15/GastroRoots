package com.gastro.roots.domain.repository;

import com.gastro.roots.domain.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findAllByStateId(Long stateId);
    List<City> findByStateIdAndNameContainingIgnoreCase(Long stateId, String name);

}
