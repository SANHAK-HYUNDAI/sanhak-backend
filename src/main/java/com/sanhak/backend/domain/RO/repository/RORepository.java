package com.sanhak.backend.domain.RO.repository;

import com.sanhak.backend.domain.RO.entity.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RORepository extends JpaRepository<RepairOrder, Long> {
}
