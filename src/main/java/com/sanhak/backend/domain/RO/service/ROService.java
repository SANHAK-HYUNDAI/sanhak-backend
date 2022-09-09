package com.sanhak.backend.domain.RO.service;

import com.sanhak.backend.domain.RO.RepairOrder;
import com.sanhak.backend.domain.RO.repository.RORepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ROService {
    private RORepository repairOrderRepository;

    public RepairOrder findById(Long id) {
        return repairOrderRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public Long deleteById(Long id) {
        repairOrderRepository.deleteById(id);
        return id;
    }
}
