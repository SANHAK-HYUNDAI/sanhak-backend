package com.sanhak.backend.domain.ro.repository;

import com.sanhak.backend.domain.ro.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepairOrderRepository extends JpaRepository<RepairOrder, Long> {
    Optional<RepairOrder> findById(Long id);

    void deleteById(Long id);
}
