package com.sanhak.backend.domain.RO.repository;

import com.sanhak.backend.domain.RO.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RORepository extends JpaRepository<RepairOrder, Long> {
    Optional<RepairOrder> findById(Long id);

    void deleteById(Long id);
}
